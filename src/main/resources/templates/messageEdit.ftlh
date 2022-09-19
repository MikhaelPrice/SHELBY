<#import "parts/common.ftlh" as c>

<@c.page>
<head>
    <h3>Редактирование записи</h3><br>
</head>
<div>
    <form method="post">
        <div class="form-group">
            <input type="text" name="text" value="${text}" class="form-control">
        </div>
        <div class="form-group">
            <input type="text" name="tag" value="${tag}" class="form-control">
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div class="form-group mt-3">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>
</@c.page>
