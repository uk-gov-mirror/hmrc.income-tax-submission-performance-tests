package uk.gov.hmrc.perftests.itsass

import io.gatling.http.Predef.{http, status}
import io.gatling.core.Predef._
import uk.gov.hmrc.performance.conf.ServicesConfiguration
import uk.gov.hmrc.perftests.itsass.IncomeTaxSubmissionRequests._

object DividendsRequests extends ServicesConfiguration {

  def getUkDividendsStatusPage = http("Get UK Dividends Status Page")
    .post(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/dividend-uk-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsStatusPage = http("Post UK Dividends Status Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/dividend-uk-status")
    .formParam( """csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getUKDividendsAmountPage = http("Get UK Dividends amount Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/dividend-uk-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postUKDividendsAmountPage = http("Post UK Dividends Amount Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/uk-dividend-amount")
    .formParam( """csrfToken""", """${csrfToken}""")
    .formParam("value", "1000")
    .check(status.is(303))

  def getOtherDividendsStatusPage = http("Get Other Dividends Status Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/other-dividend-status")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsStatusPage = http("Post Other Dividends Status Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/other-dividend-status")
    .formParam( """csrfToken""", """${csrfToken}""")
    .formParam("value", "true")
    .check(status.is(303))

  def getOtherDividendsAmountPage = http("Get Other Dividends amount Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/other-dividend-amount")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postOtherDividendsAmountPage = http("Post Other Dividends Amount Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/other-dividend-amount")
    .formParam( """csrfToken""", """${csrfToken}""")
    .formParam("value", "1000")
    .check(status.is(303))

  def getDividendsCheckYourAnswersPage = http("Get Dividends Check Your Answers Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/summary")
    .check(saveCsrfToken())
    .check(status.is(200))

  def postDividendsCheckYourAnswersPage = http("Post Dividends Check Your Answers Page")
    .get(s"$baseUrl/report-quarterly/income-and-expenses/submissions/dividends/summary")
    .formParam( """csrfToken""", """${csrfToken}""")
    .check(status.is(303))

}
