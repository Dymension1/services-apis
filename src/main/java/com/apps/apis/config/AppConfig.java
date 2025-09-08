package com.apps.apis.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Clase con la configuración de la app
 */
@Component
@ConfigurationProperties(prefix = "app")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppConfig {
    private BuildProperties buildProperties;

    @Value("${server.servlet.context-path}")
    private String contextVersion;

    private String allowedOrigins;
    private String allowedMethods;
    private String allowedHeaders;
    private String exposedHeaders;

    private static final String REGEX = "\\s*,\\s*";
    private static Pattern pattern = Pattern.compile(REGEX);

    public List<String> getListAllowedOrigins() {
        return List.of(pattern.split(allowedOrigins));
    }

    public List<String> getListAllowedMethods() {
        return List.of(pattern.split(allowedMethods));
    }

    public List<String> getListAllowedHeaders() {
        return List.of(pattern.split(allowedHeaders));
    }

    public List<String> getListExposedHeaders() {
        return List.of(exposedHeaders.split(REGEX));
    }



    @Autowired
    public AppConfig(BuildProperties buildProperties) {this.buildProperties = buildProperties;}

    public String compatibilityContextVersion() {
        int position = this.contextVersion.toLowerCase(Locale.ROOT).indexOf("/v", 0) + 2;
        String semanticContextVersion = this.contextVersion.substring(position);
        String majorVersionContext = semanticContextVersion.split("[.]")[0];
        String majorVersion = this.buildProperties.getVersion() == null ?
                majorVersionContext : this.buildProperties.getVersion().split("[.]")[0];

        if (majorVersionContext.equals(majorVersion)) {
            return this.buildProperties.getVersion();
        } else {
            return String.format("Major project version in pom.xml (%s), differs from major context version (%s)", majorVersion, semanticContextVersion);
        }
    }
}