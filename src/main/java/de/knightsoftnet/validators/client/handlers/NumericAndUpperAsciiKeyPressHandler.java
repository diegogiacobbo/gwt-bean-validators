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

import org.apache.commons.lang3.CharUtils;

/**
 * Key press handler which limits input to UperCase ASCII and numeric characters.
 *
 * @author Manfred Tremmel
 */
public class NumericAndUpperAsciiKeyPressHandler extends AbstractFilterAndReplaceKeyPressHandler {

  /**
   * default constructor.
   */
  public NumericAndUpperAsciiKeyPressHandler() {
    super(true);
  }

  @Override
  public boolean isAllowedCharacter(final char pcharacter) {
    return CharUtils.isAsciiNumeric(pcharacter) || CharUtils.isAsciiAlphaUpper(pcharacter);
  }

  @Override
  public boolean isCharacterToReplace(final char pcharacter) {
    return CharUtils.isAsciiAlphaLower(pcharacter);
  }

  @Override
  public char replaceCharacter(final char pcharacter) {
    return Character.toUpperCase(pcharacter);
  }
}