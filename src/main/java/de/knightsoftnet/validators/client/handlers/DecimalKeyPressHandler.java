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

package de.knightsoftnet.validators.client.handlers;

import com.google.gwt.i18n.client.NumberFormat;

/**
 * KeyPress Handler which allows the characters used for decimal values.
 *
 * @author Manfred Tremmel
 */
public class DecimalKeyPressHandler extends AbstractFilterKeyPressHandler {

  public DecimalKeyPressHandler() {
    super(NumberFormat.getDecimalFormat().format(1234567890.0123456789)
        + NumberFormat.getDecimalFormat().format(-1234567890.0123456789), true);
  }
}
