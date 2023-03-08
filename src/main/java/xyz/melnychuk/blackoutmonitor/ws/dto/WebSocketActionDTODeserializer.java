package xyz.melnychuk.blackoutmonitor.ws.dto;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;

public class WebSocketActionDTODeserializer extends JsonDeserializer<WebSocketActionDTO<?>> {

    @Override
    public WebSocketActionDTO<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode node = mapper.readTree(jp);

        if (!node.has("action")) {
            throw new JsonParseException(jp, "Action cannot be null.");
        }

        WebSocketAction action = WebSocketAction.valueOf(node.get("id").asText());

        Object payloadObject = null;
        if (node.has("payload")) {
            String payload = node.get("payload").asText();
            payloadObject = mapper.readValue(payload, action.getDTOClass());
        }

        return new WebSocketActionDTO<>(action, payloadObject);
    }
}
