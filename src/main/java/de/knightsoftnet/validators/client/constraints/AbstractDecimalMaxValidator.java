/*
 * Copyright 2010 Google Inc. Copyright 2016 Manfred Tremmel
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package de.knightsoftnet.validators.client.constraints;

import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.constraints.DecimalMax;

/**
 * <p>
 * Abstract {@link DecimalMax} constraint validator implementation for a <code>T</code>.
 * </p>
 *
 * @param <T> the type of object to validate
 */
public abstract class AbstractDecimalMaxValidator<T> implements ConstraintValidator<DecimalMax, T> {

  private BigDecimal max;

  @Override
  public final void initialize(final DecimalMax constraintAnnotation) {
    try {
      this.max = new BigDecimal(constraintAnnotation.value());
    } catch (final NumberFormatException e) {
      throw new IllegalArgumentException(
          constraintAnnotation.value() + " does not represent a valid BigDecimal format", e);
    }
  }

  protected final boolean isValid(final BigDecimal bigValue) {
    return this.max.compareTo(bigValue) >= 0;
  }
}
