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

import de.knightsoftnet.mtwidgets.client.ui.handler.HandlerFactory;

import com.google.gwt.user.client.TakesValue;

public class PostalCodeTextBox extends TextBox {

  /**
   * default constructor.
   */
  public PostalCodeTextBox() {
    super();
    this.setMaxLength(10);
    this.setVisibleLength(10);
  }

  /**
   * add a reference to input field contains country code.
   *
   * @param pcountryCodeField input field which contains country code
   * @deprecated use {@link #setCountryCodeReference(TakesValue)} instead
   */
  @Deprecated
  public void addCountryCodeReference(final TakesValue<?> pcountryCodeField) {
    this.setCountryCodeReference(pcountryCodeField);
  }

  /**
   * add a reference to input field contains country code.
   *
   * @param pcountryCodeField input field which contains country code
   */
  public void setCountryCodeReference(final TakesValue<?> pcountryCodeField) {
    this.addKeyPressHandler(HandlerFactory.getPostalCodeKeyPressHandler(pcountryCodeField));
  }
}
