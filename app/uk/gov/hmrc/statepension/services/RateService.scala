/*
 * Copyright 2017 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.statepension.services

import scala.math.BigDecimal.RoundingMode

object RateService {

  final val MAX_AMOUNT: BigDecimal = 155.65
  final val MAX_YEARS: BigDecimal = 35

  val spAmountPerYear: BigDecimal = MAX_AMOUNT / MAX_YEARS

  def getSPAmount(totalQualifyingYears: Int): BigDecimal = {
    if (totalQualifyingYears > MAX_YEARS) {
      MAX_AMOUNT
    } else {
      spAmountPerYear * totalQualifyingYears
    }
  }

  final val MAX_BASIC_AMOUNT: BigDecimal = 119.30
  final val MAX_BASIC_YEARS: Int = 30

  val basicSPAmountPerYear: BigDecimal = MAX_BASIC_AMOUNT / MAX_BASIC_YEARS

  def getBasicSPAmount(qualifyingYears: Int): BigDecimal = {
    if (qualifyingYears > MAX_BASIC_YEARS) {
      MAX_BASIC_AMOUNT
    } else {
      (basicSPAmountPerYear * qualifyingYears).setScale(2, RoundingMode.HALF_UP)
    }
  }

}