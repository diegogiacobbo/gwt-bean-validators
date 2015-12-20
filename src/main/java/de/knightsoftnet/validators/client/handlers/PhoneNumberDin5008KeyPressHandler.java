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

import de.knightsoftnet.validators.shared.util.PhoneNumberUtil;

import com.google.gwt.user.client.ui.HasValue;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Key press handler which limits and formats input to phone number DIN 5008 characters.
 *
 * @author Manfred Tremmel
 */
public class PhoneNumberDin5008KeyPressHandler
    extends AbstractFilterReplaceAndFormatKeyPressHandler {

  private final PhoneNumberUtil phoneNumberUtil;
  private final HasValue<?> countryCodeField;

  /**
   * constructor set reference to country code reference.
   *
   * @param pcountryCodeField reference to country code field
   */
  public PhoneNumberDin5008KeyPressHandler(final HasValue<?> pcountryCodeField) {
    super(true);
    this.countryCodeField = pcountryCodeField;
    this.phoneNumberUtil = new PhoneNumberUtil(Objects.toString(pcountryCodeField.getValue()));
  }

  @Override
  public boolean isAllowedCharacter(final char pcharacter) {
    return pcharacter == '+' || pcharacter == '-' || pcharacter == ' '
        || pcharacter >= '0' && pcharacter <= '9';
  }

  @Override
  public boolean isCharacterToReplace(final char pcharacter) {
    return false;
  }

  @Override
  public boolean isFormatingCharacter(final char pcharacter) {
    return pcharacter == ' ';
  }

  @Override
  public char replaceCharacter(final char pcharacter) {
    return pcharacter;
  }

  @Override
  public String formatValue(final String pvalue) {
    this.phoneNumberUtil.setCountryCode(Objects.toString(this.countryCodeField.getValue()));
    final String formatedValue = this.phoneNumberUtil.formatDin5008(pvalue);
    return StringUtils.isEmpty(formatedValue)
        || StringUtils.startsWith(pvalue, formatedValue) && StringUtils.endsWith(pvalue, "-")
            ? pvalue : formatedValue;
  }
}
