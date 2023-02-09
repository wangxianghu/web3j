package org.web3j.protocol.core.methods.response;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectReader;
import org.web3j.protocol.ObjectMapperFactory;
import org.web3j.protocol.core.Response;

import java.io.IOException;
import java.util.Optional;

public class EthTokenMeta  extends Response<TokenMeta> {

  public Optional<TokenMeta> getTokenMeta() {
    return Optional.ofNullable(getResult());
  }

  public static class ResponseDeserialiser extends JsonDeserializer<TokenMeta> {

    private ObjectReader objectReader = ObjectMapperFactory.getObjectReader();

    @Override
    public TokenMeta deserialize(
        JsonParser jsonParser, DeserializationContext deserializationContext)
        throws IOException {
      if (jsonParser.getCurrentToken() != JsonToken.VALUE_NULL) {
        return objectReader.readValue(jsonParser, TokenMeta.class);
      } else {
        return null; // null is wrapped by Optional in above getter
      }
    }
  }
}
