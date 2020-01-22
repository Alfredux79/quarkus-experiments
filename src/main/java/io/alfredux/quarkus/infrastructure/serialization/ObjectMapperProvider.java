package io.alfredux.quarkus.infrastructure.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.quarkus.jackson.ObjectMapperCustomizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;

@Singleton
public class ObjectMapperProvider implements ObjectMapperCustomizer {

    private static final Logger LOG = LoggerFactory.getLogger(ObjectMapperProvider.class);

    @Override
    public void customize(ObjectMapper mapper) {
        LOG.info("customizing object mapper");
        mapper.findAndRegisterModules();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
}
