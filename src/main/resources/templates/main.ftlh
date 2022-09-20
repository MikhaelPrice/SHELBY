<#include 'parts/security.ftlh'>
<#import "parts/common.ftlh" as c>
<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by date">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>
<#if known>
<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new message</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" name="text" class="form-control" placeholder="Введите сообщение" />
            </div>
            <div class="form-group">
                <input type="text" name="date" class="form-control" placeholder="Дата">
            </div>
            <div class="custom-file">
                <input type="file" name="file" id="customFile" placeholder="Choose file">
            </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group mt-3">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>
</#if>

<div class="card-columns">
    <#list messages as message>
    <div class="card my-3">
        <#if message.filename??>
            <img src="/img/${message.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <i>${message.date}</i><br>
            <span>${message.text}</span>
        </div>
        <div class="card-footer text-muted">
            ${message.authorName}
            <table>
                <tr>
                    <button type="submit"><a href="/main/${message.id}/messageEdit">edit</a></button>
                </tr>&nbsp
                <tr>
                    <form action="/remove" method="post">
                        <button type="submit">delete</button>
                    </form>
                </tr>
            </table>
        </div>
    </div>
    <#else>
    No message
    </#list>
</div>
</@c.page>