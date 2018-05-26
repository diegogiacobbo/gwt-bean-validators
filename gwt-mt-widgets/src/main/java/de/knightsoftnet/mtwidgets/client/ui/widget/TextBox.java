/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package de.knightsoftnet.mtwidgets.client.ui.widget;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A standard single-line text box.
 *
 * <p>
 * &lt;img class='gallery' src='doc-files/TextBox.png'/&gt;
 * </p>
 *
 * <h3>CSS Style Rules</h3>
 * <ul class="css">
 * <li>.gwt-TextBox { primary style }</li>
 * <li>.gwt-TextBox-readonly { dependent style set when the text box is read-only }</li>
 * </ul>
 *
 * <h3>Built-in Bidi Text Support</h3>
 * <p>
 * This widget is capable of automatically adjusting its direction according to the input text. This
 * feature is controlled by {@link #setDirectionEstimator}, and is available by default when at
 * least one of the application's locales is right-to-left.
 * </p>
 */
public class TextBox extends TextBoxBase {

  /**
   * Creates a TextBox widget that wraps an existing &lt;input type='text'&gt; element.
   *
   * <p>
   * This element must already be attached to the document. If the element is removed from the
   * document, you must call {@link RootPanel#detachNow(Widget)}.
   * </p>
   *
   * @param element the element to be wrapped
   * @return text box
   */
  public static TextBox wrap(final Element element) {
    // Assert that the element is attached.
    assert Document.get().getBody().isOrHasChild(element);

    final TextBox textBox = new TextBox(element);

    // Mark it attached and remember it for cleanup.
    textBox.onAttach();
    RootPanel.detachOnWindowClose(textBox);

    return textBox;
  }

  /**
   * Creates an empty text box.
   */
  public TextBox() {
    this(Document.get().createTextInputElement(), "gwt-TextBox");
  }

  /**
   * This constructor may be used by subclasses to explicitly use an existing element. This element
   * must be an &lt;input&gt; element whose type is 'text'.
   *
   * @param element the element to be used
   */
  protected TextBox(final Element element) {
    super(element);
    assert InputElement.as(element).getType().equalsIgnoreCase("text");
  }

  TextBox(final Element element, final String styleName) {
    super(element);
    if (styleName != null) {
      this.setStyleName(styleName);
    }
  }

  /**
   * Gets the maximum allowable length of the text box.
   *
   * @return the maximum length, in characters
   */
  public int getMaxLength() {
    return this.getInputElement().getMaxLength();
  }

  /**
   * Gets the number of visible characters in the text box.
   *
   * @return the number of visible characters
   */
  public int getVisibleLength() {
    return this.getInputElement().getSize();
  }

  /**
   * Sets the maximum allowable length of the text box.
   *
   * @param length the maximum length, in characters
   */
  public void setMaxLength(final int length) {
    this.getInputElement().setMaxLength(length);
  }

  /**
   * Sets the number of visible characters in the text box.
   *
   * @param length the number of visible characters
   */
  public void setVisibleLength(final int length) {
    this.getInputElement().setSize(length);
  }
}
