$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/LoginPage.feature");
formatter.feature({
  "line": 1,
  "name": "Tests and verifies all the login page flows.",
  "description": "",
  "id": "tests-and-verifies-all-the-login-page-flows.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 626400,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify each element on the login screen.",
  "description": "",
  "id": "tests-and-verifies-all-the-login-page-flows.;verify-each-element-on-the-login-screen.",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 15,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 16,
  "name": "Verify login page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 238154900,
  "status": "passed"
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_login_page()"
});
formatter.result({
  "duration": 79800,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Verify the default langauge selection on the login screen.-C3186",
  "description": "",
  "id": "tests-and-verifies-all-the-login-page-flows.;verify-the-default-langauge-selection-on-the-login-screen.-c3186",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Verify default language is \u003clanguage\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 23,
  "name": "",
  "description": "",
  "id": "tests-and-verifies-all-the-login-page-flows.;verify-the-default-langauge-selection-on-the-login-screen.-c3186;",
  "rows": [
    {
      "cells": [
        "language"
      ],
      "line": 24,
      "id": "tests-and-verifies-all-the-login-page-flows.;verify-the-default-langauge-selection-on-the-login-screen.-c3186;;1"
    },
    {
      "cells": [
        "english"
      ],
      "line": 25,
      "id": "tests-and-verifies-all-the-login-page-flows.;verify-the-default-langauge-selection-on-the-login-screen.-c3186;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 70700,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Verify the default langauge selection on the login screen.-C3186",
  "description": "",
  "id": "tests-and-verifies-all-the-login-page-flows.;verify-the-default-langauge-selection-on-the-login-screen.-c3186;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@SPRegression"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "User is on login page of website",
  "keyword": "Given "
});
formatter.step({
  "line": 21,
  "name": "Verify default language is english",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 76300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "english",
      "offset": 27
    }
  ],
  "location": "LoginPageStepDefinitions.verify_default_language_is(String)"
});
formatter.result({
  "duration": 2239000,
  "status": "passed"
});
});