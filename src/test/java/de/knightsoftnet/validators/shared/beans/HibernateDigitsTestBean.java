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

package de.knightsoftnet.validators.shared.beans;

import javax.validation.constraints.Digits;

public class HibernateDigitsTestBean {

  @Digits(integer = 5, fraction = 2)
  private final Double number;

  public HibernateDigitsTestBean(final Double pnumber) {
    super();
    this.number = pnumber;
  }

  public final Double getNumber() {
    return this.number;
  }

  @Override
  public String toString() {
    return "HibernateDigitsTestBean [number=" + this.number + "]";
  }
}
