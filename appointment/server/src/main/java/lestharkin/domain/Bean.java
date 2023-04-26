package lestharkin.domain;

import java.io.Serializable;

public class Bean<B extends Serializable, M extends Serializable> implements Serializable {
  private static final long serialVersionUID = 10202101L;
  private B data;
  private M message;

  public Bean(B data, M message) {
    this.data = data;
    this.message = message;
  }

  public B getData() {
    return data;
  }

  public void setData(B data) {
    this.data = data;
  }

  public M getMessage() {
    return message;
  }

  public void setMessage(M message) {
    this.message = message;
  }

}
