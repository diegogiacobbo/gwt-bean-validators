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

import de.knightsoftnet.mtwidgets.client.ui.widget.features.HasMultiple;

import com.google.gwt.text.shared.testing.PassthroughParser;
import com.google.gwt.text.shared.testing.PassthroughRenderer;

import elemental.client.Browser;

/**
 * html 5 input field of type email.
 *
 * @author Manfred Tremmel
 *
 */
public class EmailTextBox extends ValueBox<String> implements HasMultiple {

  /**
   * default constructor.
   */
  public EmailTextBox() {
    super(Browser.getDocument().createInputElement(), "email", PassthroughRenderer.instance(),
        PassthroughParser.instance());
  }

  @Override
  public boolean isMultiple() {
    return this.getInputElement().isMultiple();
  }

  @Override
  public void setMultiple(final boolean arg) {
    this.getInputElement().setMultiple(arg);
  }
}