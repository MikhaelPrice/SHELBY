<#include 'security.ftlh'>
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">
        <img src="https://th.bing.com/th/id/R.f46ab258aa80aae5b37dbedf46bc03bc?rik=rd9%2ftSVLASg%2f2Q&pid=ImgRaw&r=0"
        height="30" width="50">
        Shelby</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Messages</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </#if>
            <li class="nav-item">
                <a class="nav-link" href="/calculator">online-calculator</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/cryptocurrency">crypto prices</a>
            </li>
        </ul>
        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
    </div>
</nav>