/*
 * Copyright 2020 HM Revenue & Customs
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

package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._

object AuthLoginRequests extends ServicesConfiguration {

  def getLoginPage = http("Get Login Page")
    .get(authLoginUrl + s"/auth-login-stub/gg-sign-in")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postIndividualLoginPage = http("Post Individual Login page")
    .post(authLoginUrl + "/auth-login-stub/gg-sign-in": String)
    .formParam("authorityId", "")
    .formParam("gatewayToken", "")
    .formParam("redirectionUrl", s"$serviceUrl/2020/start")
    .formParam("credentialStrength", "strong")
    .formParam("confidenceLevel", "200")
    .formParam("affinityGroup", "Individual")
    .formParam("usersName", "")
    .formParam("email", "")
    .formParam("credentialRole", "")
    .formParam("oauthTokens.accessToken", "")
    .formParam("oauthTokens.refreshToken", "")
    .formParam("oauthTokens.idToken", "")
    .formParam("additionalInfo.profile", "")
    .formParam("additionalInfo.groupProfile", "")
    .formParam("additionalInfo.emailVerified", "")
    .formParam("nino", "AA123456A")
    .formParam("groupIdentifier", "")
    .formParam("agent.agentId", "")
    .formParam("agent.agentCode", "")
    .formParam("agent.agentFriendlyName", "")
    .formParam("unreadMessageCount", "")
    .formParam("mdtp.sessionId", "")
    .formParam("mdtp.deviceId", "")
    .formParam("presets-dropdown", "IR-CT")
    .formParam("enrolment[0].name", "HMRC-MTD-IT")
    .formParam("enrolment[0].taxIdentifier[0].name", "MTDITID")
    .formParam("enrolment[0].taxIdentifier[0].value", "1234567890")
    .formParam("enrolment[0].state", "Activated")
    .formParam("enrolment[1].name", "")
    .formParam("enrolment[1].taxIdentifier[0].name", "")
    .formParam("enrolment[1].taxIdentifier[0].value", "")
    .formParam("enrolment[1].state", "Activated")
    .formParam("enrolment[2].name", "")
    .formParam("enrolment[2].taxIdentifier[0].name", "")
    .formParam("enrolment[2].taxIdentifier[0].value", "")
    .formParam("enrolment[2].state", "Activated")
    .formParam("enrolment[3].name", "")
    .formParam("enrolment[3].taxIdentifier[0].name", "")
    .formParam("enrolment[3].taxIdentifier[0].value", "")
    .formParam("enrolment[3].state", "Activated")
    .formParam("enrolment[4].name", "")
    .formParam("enrolment[4].taxIdentifier[0].name", "")
    .formParam("enrolment[4].taxIdentifier[0].value", "")
    .formParam("enrolment[4].state", "Activated")
    .formParam("itmp.givenName", "")
    .formParam("itmp.middleName", "")
    .formParam("itmp.familyName", "")
    .formParam("itmp.dateOfBirth", "")
    .formParam("itmp.address.line1", "")
    .formParam("itmp.address.line2", "")
    .formParam("itmp.address.line3", "")
    .formParam("itmp.address.line4", "")
    .formParam("itmp.address.line5", "")
    .formParam("itmp.address.postCode", "")
    .formParam("itmp.address.countryName", "")
    .formParam("itmp.address.countryCode", "")
    .check(status.is(303))

  def postAgentLoginPage = http("Post Agent Login page")
    .post(authLoginUrl + "/auth-login-stub/gg-sign-in": String)
    .formParam("authorityId", "")
    .formParam("gatewayToken", "")
    .formParam("redirectionUrl", s"$serviceUrl/2020/start")
    .formParam("credentialStrength", "weak")
    .formParam("confidenceLevel", "50")
    .formParam("affinityGroup", "Agent")
    .formParam("usersName", "")
    .formParam("email", "")
    .formParam("credentialRole", "")
    .formParam("oauthTokens.accessToken", "")
    .formParam("oauthTokens.refreshToken", "")
    .formParam("oauthTokens.idToken", "")
    .formParam("additionalInfo.profile", "")
    .formParam("additionalInfo.groupProfile", "")
    .formParam("additionalInfo.emailVerified", "")
    .formParam("nino", "")
    .formParam("groupIdentifier", "")
    .formParam("agent.agentId", "")
    .formParam("agent.agentCode", "")
    .formParam("agent.agentFriendlyName", "")
    .formParam("unreadMessageCount", "")
    .formParam("mdtp.sessionId", "")
    .formParam("mdtp.deviceId", "")
    .formParam("presets-dropdown", "IR-CT")
    .formParam("enrolment[0].name", "HMRC-MTD-IT")
    .formParam("enrolment[0].taxIdentifier[0].name", "MTDITID")
    .formParam("enrolment[0].taxIdentifier[0].value", "1234567890")
    .formParam("enrolment[0].state", "Activated")
    .formParam("enrolment[1].name", "HMRC-AS-AGENT")
    .formParam("enrolment[1].taxIdentifier[0].name", "AgentReferenceNumber")
    .formParam("enrolment[1].taxIdentifier[0].value", "XARN1234567")
    .formParam("enrolment[1].state", "Activated")
    .formParam("enrolment[2].name", "")
    .formParam("enrolment[2].taxIdentifier[0].name", "")
    .formParam("enrolment[2].taxIdentifier[0].value", "")
    .formParam("enrolment[2].state", "Activated")
    .formParam("enrolment[3].name", "")
    .formParam("enrolment[3].taxIdentifier[0].name", "")
    .formParam("enrolment[3].taxIdentifier[0].value", "")
    .formParam("enrolment[3].state", "Activated")
    .formParam("enrolment[4].name", "")
    .formParam("enrolment[4].taxIdentifier[0].name", "")
    .formParam("enrolment[4].taxIdentifier[0].value", "")
    .formParam("enrolment[4].state", "Activated")
    .formParam("itmp.givenName", "")
    .formParam("itmp.middleName", "")
    .formParam("itmp.familyName", "")
    .formParam("itmp.dateOfBirth", "")
    .formParam("itmp.address.line1", "")
    .formParam("itmp.address.line2", "")
    .formParam("itmp.address.line3", "")
    .formParam("itmp.address.line4", "")
    .formParam("itmp.address.line5", "")
    .formParam("itmp.address.postCode", "")
    .formParam("itmp.address.countryName", "")
    .formParam("itmp.address.countryCode", "")
    .check(status.is(303))
}
