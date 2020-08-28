$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/ForgotPasswordPage.feature");
formatter.feature({
  "line": 1,
  "name": "Tests and verifies all the Forgot password  page flows.",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 562200,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Verify each element on the Forgot password screen.",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-each-element-on-the-forgot-password-screen.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 2,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User redirects to forgot password page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Verify Forgot password page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 90637421700,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPasswordPageStepDefinitions.user_redirects_to_forgot_password_page()"
});
formatter.result({
  "duration": 185698200,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPasswordPageStepDefinitions.verify_Forgot_password_page()"
});
formatter.result({
  "duration": 294337700,
  "status": "passed"
});
formatter.before({
  "duration": 193600,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify the back to login link on the Forgot password screen.",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-back-to-login-link-on-the-forgot-password-screen.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 8,
      "name": "@SPRegression"
    },
    {
      "line": 8,
      "name": "@forgot"
    }
  ]
});
formatter.step({
  "line": 10,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "User redirects to forgot password page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on back to login link",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "Verify login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 231206000,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPasswordPageStepDefinitions.user_redirects_to_forgot_password_page()"
});
formatter.result({
  "duration": 124124000,
  "status": "passed"
});
formatter.match({
  "location": "ForgotPasswordPageStepDefinitions.user_clicks_on_back_to_login_link()"
});
formatter.result({
  "duration": 129651200,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_login_page()"
});
formatter.result({
  "duration": 525749900,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Verify the forgot password functionality",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-forgot-password-functionality",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 15,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User requests password for \u003cemail\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Verify user gets success notification \u003cnotification\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Verify login page",
  "keyword": "Then "
});
formatter.examples({
  "line": 22,
  "name": "",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-forgot-password-functionality;",
  "rows": [
    {
      "cells": [
        "email",
        "notification"
      ],
      "line": 23,
      "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-forgot-password-functionality;;1"
    },
    {
      "cells": [
        "naresh@squarepanda.com",
        "Email has been sent"
      ],
      "line": 24,
      "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-forgot-password-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 149600,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Verify the forgot password functionality",
  "description": "",
  "id": "tests-and-verifies-all-the-forgot-password--page-flows.;verify-the-forgot-password-functionality;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 15,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "User requests password for naresh@squarepanda.com",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "Verify user gets success notification Email has been sent",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "Verify login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 90280117200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "naresh@squarepanda.com",
      "offset": 27
    }
  ],
  "location": "ForgotPasswordPageStepDefinitions.user_requests_password_for_email(String)"
});
formatter.result({
  "duration": 618567400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Email has been sent",
      "offset": 38
    }
  ],
  "location": "LoginPageStepDefinitions.verify_user_gets_success_message(String)"
});
formatter.result({
  "duration": 1802247100,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_login_page()"
});
formatter.result({
  "duration": 493855900,
  "status": "passed"
});
});