<#import "parts/common.ftlh" as c>

<@c.page>
<html lang="en">
<head>
    <meta charset="UTF-8">
</head>
<body>
    <form action="/vars">
        <div name="vars" class="form-control" align="left">
            <#if vars??>
                ${vars}
            </#if>
        </div>
    </form>
</body>
</html>
</@c.page>