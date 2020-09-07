$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Features/ResendActivationMailPage.feature");
formatter.feature({
  "line": 1,
  "name": "Tests and verifies all the resend activation mail page flows.",
  "description": "",
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 401000,
  "status": "passed"
});
formatter.scenario({
  "line": 3,
  "name": "Verify each element on the Forgot password screen.",
  "description": "",
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-each-element-on-the-forgot-password-screen.",
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
  "name": "User redirects to resend activation email page",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Verify resend activation email page",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_user_is_on_login_page_of_website()"
});
formatter.result({
  "duration": 59802962200,
  "error_message": "java.lang.Exception: \nException Stack Trace    :  org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d85.0.4183.83)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-G6GITERP\u0027, ip: \u0027192.168.43.19\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 85.0.4183.83, chrome: {chromedriverVersion: 85.0.4183.87 (cd6713ebf92fa..., userDataDir: C:\\Users\\Naresh\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55991}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 5e6381650b5e7da6af2ad85c80bf9589\n*** Element info: {Using\u003dxpath, value\u003d//h1[@class\u003d\u0027authTitle\u0027]}\r\n\tat sun.reflect.GeneratedConstructorAccessor15.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown \r\n\tat com.squarepanda.reporting.ErrorReporter.createErrorMapAndThrowException(ErrorReporter.java:112)\r\n\tat com.squarepanda.reporting.ErrorReporter.reportError(ErrorReporter.java:26)\r\n\tat com.squarepanda.stepdefinitions.LoginPageStepDefinitions.verify_user_is_on_login_page_of_website(LoginPageStepDefinitions.java:29)\r\n\tat ✽.Given User is on login page of website(src/test/resources/Features/ResendActivationMailPage.feature:4)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ResendActivationMailPageStepDefinitions.user_redirects_to_resend_activation_email_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ResendActivationMailPageStepDefinitions.verify_resend_activation_email_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.before({
  "duration": 297500,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Verify the back to login link on the Resend Activation email screen.",
  "description": "",
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-back-to-login-link-on-the-resend-activation-email-screen.",
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
  "name": "User redirects to resend activation email page",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User clicks on back to login link on resend activation email",
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
  "duration": 5778600,
  "error_message": "java.lang.Exception: \nException Stack Trace    :  org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d85.0.4183.83)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-G6GITERP\u0027, ip: \u0027192.168.43.19\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 85.0.4183.83, chrome: {chromedriverVersion: 85.0.4183.87 (cd6713ebf92fa..., userDataDir: C:\\Users\\Naresh\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55991}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 5e6381650b5e7da6af2ad85c80bf9589\r\n\tat sun.reflect.GeneratedConstructorAccessor15.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown S\r\n\tat com.squarepanda.reporting.ErrorReporter.createErrorMapAndThrowException(ErrorReporter.java:112)\r\n\tat com.squarepanda.reporting.ErrorReporter.reportError(ErrorReporter.java:26)\r\n\tat com.squarepanda.stepdefinitions.LoginPageStepDefinitions.verify_user_is_on_login_page_of_website(LoginPageStepDefinitions.java:29)\r\n\tat ✽.Given User is on login page of website(src/test/resources/Features/ResendActivationMailPage.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "ResendActivationMailPageStepDefinitions.user_redirects_to_resend_activation_email_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "ResendActivationMailPageStepDefinitions.user_clicks_on_back_to_login_link()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Verify the Resend Activation email functionality",
  "description": "",
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-resend-activation-email-functionality",
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
  "name": "User recovers account \u003cemail\u003e",
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
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-resend-activation-email-functionality;",
  "rows": [
    {
      "cells": [
        "email",
        "notification"
      ],
      "line": 23,
      "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-resend-activation-email-functionality;;1"
    },
    {
      "cells": [
        "naresh@squarepanda.com",
        "Email has been sent"
      ],
      "line": 24,
      "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-resend-activation-email-functionality;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 138300,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Verify the Resend Activation email functionality",
  "description": "",
  "id": "tests-and-verifies-all-the-resend-activation-mail-page-flows.;verify-the-resend-activation-email-functionality;;2",
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
  "name": "User recovers account naresh@squarepanda.com",
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
  "duration": 3158500,
  "error_message": "java.lang.Exception: \nException Stack Trace    :  org.openqa.selenium.NoSuchWindowException: no such window: target window already closed\nfrom unknown error: web view not found\n  (Session info: chrome\u003d85.0.4183.83)\nBuild info: version: \u00273.141.59\u0027, revision: \u0027e82be7d358\u0027, time: \u00272018-11-14T08:17:03\u0027\nSystem info: host: \u0027LAPTOP-G6GITERP\u0027, ip: \u0027192.168.43.19\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_211\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 85.0.4183.83, chrome: {chromedriverVersion: 85.0.4183.87 (cd6713ebf92fa..., userDataDir: C:\\Users\\Naresh\\AppData\\Loc...}, goog:chromeOptions: {debuggerAddress: localhost:55991}, javascriptEnabled: true, networkConnectionEnabled: false, pageLoadStrategy: normal, platform: WINDOWS, platformName: WINDOWS, proxy: Proxy(), setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:virtualAuthenticators: true}\nSession ID: 5e6381650b5e7da6af2ad85c80bf9589\r\n\tat sun.reflect.GeneratedConstructorAccessor15.newInstance(Unknown Source)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(Unknown Source)\r\n\tat java.lang.reflect.Constructor.newInstance(Unknown S\r\n\tat com.squarepanda.reporting.ErrorReporter.createErrorMapAndThrowException(ErrorReporter.java:112)\r\n\tat com.squarepanda.reporting.ErrorReporter.reportError(ErrorReporter.java:26)\r\n\tat com.squarepanda.stepdefinitions.LoginPageStepDefinitions.verify_user_is_on_login_page_of_website(LoginPageStepDefinitions.java:29)\r\n\tat ✽.Given User is on login page of website(src/test/resources/Features/ResendActivationMailPage.feature:17)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "naresh@squarepanda.com",
      "offset": 22
    }
  ],
  "location": "ResendActivationMailPageStepDefinitions.user_recovers_account(String)"
});
formatter.result({
  "status": "skipped"
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
  "status": "skipped"
});
formatter.match({
  "location": "LoginPageStepDefinitions.verify_login_page()"
});
formatter.result({
  "status": "skipped"
});
});