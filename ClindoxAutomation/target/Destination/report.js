$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Login.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "LoginTest",
  "description": "",
  "id": "login;logintest",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "clicked on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user should get result as \"\u003cresult\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 8,
  "name": "",
  "description": "",
  "id": "login;logintest;",
  "rows": [
    {
      "cells": [
        "username",
        "password",
        "result"
      ],
      "line": 9,
      "id": "login;logintest;;1"
    },
    {
      "cells": [
        "test",
        "test",
        "There has been an error. Your username or password is incorrect. Please try again..."
      ],
      "line": 10,
      "id": "login;logintest;;2"
    },
    {
      "cells": [
        "test",
        "",
        "There has been an error. Your username or password is incorrect. Please try again..."
      ],
      "line": 11,
      "id": "login;logintest;;3"
    },
    {
      "cells": [
        "",
        "test",
        "There has been an error. Your username or password is incorrect. Please try again..."
      ],
      "line": 12,
      "id": "login;logintest;;4"
    },
    {
      "cells": [
        "default",
        "default",
        "successful"
      ],
      "line": 13,
      "id": "login;logintest;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 10,
  "name": "LoginTest",
  "description": "",
  "id": "login;logintest;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter \"test\" and \"test\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "clicked on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user should get result as \"There has been an error. Your username or password is incorrect. Please try again...\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_launch_the_application()"
});
formatter.result({
  "duration": 9421284555,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 7
    },
    {
      "val": "test",
      "offset": 18
    }
  ],
  "location": "LoginSteps.enter_and(String,String)"
});
formatter.result({
  "duration": 209698507,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clicked_on_Login_button()"
});
formatter.result({
  "duration": 264230978,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "There has been an error. Your username or password is incorrect. Please try again...",
      "offset": 27
    }
  ],
  "location": "LoginSteps.user_should_get_result_as(String)"
});
formatter.result({
  "duration": 64611419,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "LoginTest",
  "description": "",
  "id": "login;logintest;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter \"test\" and \"\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "clicked on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user should get result as \"There has been an error. Your username or password is incorrect. Please try again...\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_launch_the_application()"
});
formatter.result({
  "duration": 128307414,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "test",
      "offset": 7
    },
    {
      "val": "",
      "offset": 18
    }
  ],
  "location": "LoginSteps.enter_and(String,String)"
});
formatter.result({
  "duration": 147933063,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clicked_on_Login_button()"
});
formatter.result({
  "duration": 290607693,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "There has been an error. Your username or password is incorrect. Please try again...",
      "offset": 27
    }
  ],
  "location": "LoginSteps.user_should_get_result_as(String)"
});
formatter.result({
  "duration": 25349369,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"ErrorMsg\"}\n  (Session info: chrome\u003d53.0.2785.116)\n  (Driver info: chromedriver\u003d2.23.409699 (49b0fa931cda1caad0ae15b7d1b68004acd05129),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 21 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.39.0\u0027, revision: \u002714fa800511cc5d66d426e08b0b2ab926c7ed7398\u0027, time: \u00272013-12-16 13:18:38\u0027\nSystem info: host: \u0027Agastya\u0027, ip: \u0027192.168.0.7\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.23.409699 (49b0fa931cda1caad0ae15b7d1b68004acd05129), userDataDir\u003dC:\\Users\\RUPALI\\AppData\\Local\\Temp\\scoped_dir12592_29771}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d53.0.2785.116, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: ea59b29760a3bcc2a29d2d4f2eb7b4db\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:193)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:145)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:554)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:307)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:348)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:220)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:299)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:59)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:34)\r\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\r\n\tat clindox.com.pages.LoginPage.ValidateLogin(LoginPage.java:52)\r\n\tat clindox.com.glue.LoginSteps.user_should_get_result_as(LoginSteps.java:54)\r\n\tat ✽.Then user should get result as \"There has been an error. Your username or password is incorrect. Please try again...\"(Login.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 12,
  "name": "LoginTest",
  "description": "",
  "id": "login;logintest;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter \"\" and \"test\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "clicked on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user should get result as \"There has been an error. Your username or password is incorrect. Please try again...\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_launch_the_application()"
});
formatter.result({
  "duration": 116412281,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "",
      "offset": 7
    },
    {
      "val": "test",
      "offset": 14
    }
  ],
  "location": "LoginSteps.enter_and(String,String)"
});
formatter.result({
  "duration": 150658807,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clicked_on_Login_button()"
});
formatter.result({
  "duration": 205657054,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "There has been an error. Your username or password is incorrect. Please try again...",
      "offset": 27
    }
  ],
  "location": "LoginSteps.user_should_get_result_as(String)"
});
formatter.result({
  "duration": 19508349,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"id\",\"selector\":\"ErrorMsg\"}\n  (Session info: chrome\u003d53.0.2785.116)\n  (Driver info: chromedriver\u003d2.23.409699 (49b0fa931cda1caad0ae15b7d1b68004acd05129),platform\u003dWindows NT 10.0.14393 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 19 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00272.39.0\u0027, revision: \u002714fa800511cc5d66d426e08b0b2ab926c7ed7398\u0027, time: \u00272013-12-16 13:18:38\u0027\nSystem info: host: \u0027Agastya\u0027, ip: \u0027192.168.0.7\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_91\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, mobileEmulationEnabled\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.23.409699 (49b0fa931cda1caad0ae15b7d1b68004acd05129), userDataDir\u003dC:\\Users\\RUPALI\\AppData\\Local\\Temp\\scoped_dir12592_29771}, takesHeapSnapshot\u003dtrue, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, hasTouchScreen\u003dfalse, version\u003d53.0.2785.116, platform\u003dXP, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, acceptSslCerts\u003dtrue, locationContextEnabled\u003dtrue, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: ea59b29760a3bcc2a29d2d4f2eb7b4db\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:193)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:145)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:554)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:307)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementById(RemoteWebDriver.java:348)\r\n\tat org.openqa.selenium.By$ById.findElement(By.java:220)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:299)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:59)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:34)\r\n\tat com.sun.proxy.$Proxy14.getText(Unknown Source)\r\n\tat clindox.com.pages.LoginPage.ValidateLogin(LoginPage.java:52)\r\n\tat clindox.com.glue.LoginSteps.user_should_get_result_as(LoginSteps.java:54)\r\n\tat ✽.Then user should get result as \"There has been an error. Your username or password is incorrect. Please try again...\"(Login.feature:7)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 13,
  "name": "LoginTest",
  "description": "",
  "id": "login;logintest;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 4,
  "name": "user launch the application",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "enter \"default\" and \"default\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "clicked on Login button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user should get result as \"successful\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "LoginSteps.user_launch_the_application()"
});
formatter.result({
  "duration": 118633638,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "default",
      "offset": 7
    },
    {
      "val": "default",
      "offset": 21
    }
  ],
  "location": "LoginSteps.enter_and(String,String)"
});
formatter.result({
  "duration": 239829290,
  "status": "passed"
});
formatter.match({
  "location": "LoginSteps.clicked_on_Login_button()"
});
formatter.result({
  "duration": 4421520620,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "successful",
      "offset": 27
    }
  ],
  "location": "LoginSteps.user_should_get_result_as(String)"
});
formatter.result({
  "duration": 54192793,
  "status": "passed"
});
formatter.uri("SelectRole.feature");
formatter.feature({
  "line": 1,
  "name": "SelectRole",
  "description": "",
  "id": "selectrole",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 5,
  "name": "SelectRole",
  "description": "",
  "id": "selectrole;selectrole",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is on Dashboard Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "changes role as \"\u003cRole\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "role Should be changed Successfully as \"\u003cRole\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "line": 9,
  "name": "",
  "description": "",
  "id": "selectrole;selectrole;",
  "rows": [
    {
      "cells": [
        "Role"
      ],
      "line": 10,
      "id": "selectrole;selectrole;;1"
    },
    {
      "cells": [
        "Admin"
      ],
      "line": 11,
      "id": "selectrole;selectrole;;2"
    },
    {
      "cells": [
        "Investigator"
      ],
      "line": 12,
      "id": "selectrole;selectrole;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 2,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 3,
  "name": "User is Logged in to Application",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 11,
  "name": "SelectRole",
  "description": "",
  "id": "selectrole;selectrole;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is on Dashboard Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "changes role as \"Admin\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "role Should be changed Successfully as \"Admin\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.background({
  "line": 2,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 3,
  "name": "User is Logged in to Application",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "line": 12,
  "name": "SelectRole",
  "description": "",
  "id": "selectrole;selectrole;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 6,
  "name": "user is on Dashboard Page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "changes role as \"Investigator\"",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "role Should be changed Successfully as \"Investigator\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});