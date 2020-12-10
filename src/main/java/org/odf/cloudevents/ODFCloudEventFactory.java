package org.odf.cloudevents;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import java.net.URI;
/**
 * Class to generate Cloud Events for the ODF
 */
public class ODFCloudEventFactory {

  public CloudEvent makeCloudEvent(String id, String type, String uri, String data) {
    final CloudEvent event = CloudEventBuilder.v1()
        .withId(id)
        .withType(type)
        .withSource(URI.create(uri))
        .withData(data.getBytes())
        .build();
    return event;
  }

  public static void main(String[] args) {
    CloudEvent ce = new ODFCloudEventFactory().
        makeCloudEvent("foo", "poo","htp://www.google.com", "data");
    System.out.println(ce);
  }
}
