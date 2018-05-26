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

package de.knightsoftnet.mtwidgets.client.ui.widget.helper;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * render date value to text without separators.
 *
 * @author Manfred Tremmel
 */
public class MonthRenderer extends AbstractRenderer<Date> {

  private static volatile MonthRenderer instanceRenderer = null;
  private final DateTimeFormat dateTimeFormat;

  /**
   * returns the instance.
   *
   * @return Renderer
   */
  public static final Renderer<Date> instance() { // NOPMD it's thread save!
    if (MonthRenderer.instanceRenderer == null) {
      synchronized (MonthRenderer.class) {
        if (MonthRenderer.instanceRenderer == null) {
          MonthRenderer.instanceRenderer = new MonthRenderer("yyyy-MM");
        }
      }
    }
    return MonthRenderer.instanceRenderer;
  }

  public MonthRenderer(final String pformat) {
    super();
    this.dateTimeFormat = DateTimeFormat.getFormat(pformat);
  }

  @Override
  public String render(final Date pobject) {
    if (pobject == null) {
      return StringUtils.EMPTY;
    }
    return this.dateTimeFormat.format(pobject);
  }
}