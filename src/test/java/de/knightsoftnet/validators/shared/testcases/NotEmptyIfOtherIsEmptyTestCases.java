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

package de.knightsoftnet.validators.shared.testcases;

import de.knightsoftnet.validators.shared.beans.NotEmptyIfOtherIsEmptyTestBean;

import java.util.ArrayList;
import java.util.List;

/**
 * get test cases for (not) empty if other has value test.
 *
 * @author Manfred Tremmel
 *
 */
public class NotEmptyIfOtherIsEmptyTestCases {

  /**
   * get beans with empty value.
   *
   * @return correct test beans
   */
  public static final List<NotEmptyIfOtherIsEmptyTestBean> getBothFilledBeans() {
    final List<NotEmptyIfOtherIsEmptyTestBean> correctCases =
        new ArrayList<NotEmptyIfOtherIsEmptyTestBean>();
    correctCases.add(new NotEmptyIfOtherIsEmptyTestBean("filled", "filled"));
    return correctCases;
  }

  /**
   * get beans with unchecked value.
   *
   * @return correct test beans
   */
  public static final List<NotEmptyIfOtherIsEmptyTestBean> getAlternateFilledBeans() {
    final List<NotEmptyIfOtherIsEmptyTestBean> correctCases =
        new ArrayList<NotEmptyIfOtherIsEmptyTestBean>();
    correctCases.add(new NotEmptyIfOtherIsEmptyTestBean("filled", null));
    correctCases.add(new NotEmptyIfOtherIsEmptyTestBean("filled", ""));
    correctCases.add(new NotEmptyIfOtherIsEmptyTestBean(null, "filled"));
    correctCases.add(new NotEmptyIfOtherIsEmptyTestBean("", "filled"));
    return correctCases;
  }

  /**
   * get wrong test beans.
   *
   * @return wrong test beans
   */
  public static final List<NotEmptyIfOtherIsEmptyTestBean> getWrongEmptyTestBeans() {
    final List<NotEmptyIfOtherIsEmptyTestBean> wrongCases =
        new ArrayList<NotEmptyIfOtherIsEmptyTestBean>();
    wrongCases.add(new NotEmptyIfOtherIsEmptyTestBean(null, null));
    wrongCases.add(new NotEmptyIfOtherIsEmptyTestBean(null, ""));
    wrongCases.add(new NotEmptyIfOtherIsEmptyTestBean("", null));
    wrongCases.add(new NotEmptyIfOtherIsEmptyTestBean("", ""));
    return wrongCases;
  }
}
