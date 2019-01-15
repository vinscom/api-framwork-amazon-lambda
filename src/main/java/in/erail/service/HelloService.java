package in.erail.service;

import com.google.common.net.MediaType;
import in.erail.model.Event;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.vertx.core.json.JsonArray;

public class HelloService extends RESTServiceImpl {

  private JsonArray mHelloData = new JsonArray();

  public HelloService() {
    mHelloData.add("S1");
    mHelloData.add("S2");
    mHelloData.add("S3");
    mHelloData.add("S4");
    mHelloData.add("S5");
  }

  @Override
  public MaybeSource<Event> process(Maybe<Event> pEvent) {
    return pEvent.doOnSuccess(e -> e
            .getResponse()
            .setBody(getHelloData().toString().getBytes())
            .setMediaType(MediaType.JSON_UTF_8));
  }

  public JsonArray getHelloData() {
    return mHelloData;
  }

  public void setHelloData(JsonArray pHelloData) {
    this.mHelloData = pHelloData;
  }

}
