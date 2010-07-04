package org.gwtmpv.dispatch.client.events;

import org.gwtmpv.GenEvent;
import org.gwtmpv.dispatch.shared.Action;

@GenEvent
public class DispatchUnhandledFailureEventSpec {
  Action<?> p1action;
  Throwable p2throwable;
  String p3message;
}
