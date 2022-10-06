<#import "parts/common.ftlh" as c>

<@c.page>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    <!-- Bootstrap core CSS -->
    <link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <meta name="theme-color" content="#7952b3">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }
      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    p {
        text-indent: 10px;
        margin-top: 1em;
        margin-bottom: 1em;
    }

    </style>
    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">
</head>
<body class="text-center">

<h5 name="Greeting" class="h3 mb-3 fw-normal">Matrix, Vector and Scalar calculator</h5>
    <form name="calculator" action="/calculator">
        <div class="form-group">
            <input type="text" class="form-control" name="expression" value="${expression}" placeholder="Enter an expression to calculate"><br>
            <input type="button" value="0" onClick="document.calculator.expression.value+='0'">
            <input type="button" value="1" onClick="document.calculator.expression.value+='1'">
            <input type="button" value="2" onClick="document.calculator.expression.value+='2'">
            <input type="button" value="3" onClick="document.calculator.expression.value+='3'"><br>
            <input type="button" value="4" onClick="document.calculator.expression.value+='4'">
            <input type="button" value="5" onClick="document.calculator.expression.value+='5'">
            <input type="button" value="6" onClick="document.calculator.expression.value+='6'">
            <input type="button" value="7" onClick="document.calculator.expression.value+='7'"><br>
            <input type="button" value="8" onClick="document.calculator.expression.value+='8'">
            <input type="button" value="9" onClick="document.calculator.expression.value+='9'">
            <input type="button" value="." onClick="document.calculator.expression.value+='.'">
            <input type="button" value="," onClick="document.calculator.expression.value+=','">
            <input type="button" value="=" onClick="document.calculator.expression.value+='='">
            <input type="reset" value="<-"><br>
            <tr><input type="button" value="+" onClick="document.calculator.expression.value+='+'">
                <input type="button" value="-" onClick="document.calculator.expression.value+='-'">
                <input type="button" value="*" onClick="document.calculator.expression.value+='*'">
                <input type="button" value="/" onClick="document.calculator.expression.value+='/'">
                <input type="button" value="^" onClick="document.calculator.expression.value+='^'"></tr>
            <input type="button" value="{" onClick="document.calculator.expression.value+='{'">
            <input type="button" value="}" onClick="document.calculator.expression.value+='}'">
            <input type="button" value="(" onClick="document.calculator.expression.value+='('">
            <input type="button" value=")" onClick="document.calculator.expression.value+=')'">
        </div>
        <div class="form-group">
            <button class="w-20 btn btn-lg btn-primary" type="submit">Count</button><br>
        </div>
    </form>
        <br><div class="form-group">
            <output class="form-control" name="result" align="left">
                <#if result??>
                    ${result}
                </#if>
            </output>
        </div>
    <p><a href="vars">
        <button class="btn btn-primary">Show variables</button>
    </a></p>
<p><h5>Examples: {{2,-5},{4,3}}-matrix 2x2, {4,-8,0}-vector, "*"-multiplication, "/"-division, "^"-to grade (only for scalars and vectors)</h5>
</body>
</html>
</@c.page>