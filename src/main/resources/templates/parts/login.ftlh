<#macro login path isRegisterForm>
<form action="${path}" method="post">
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email : </label>
        <div class="com-sm-10">
            <input type="text" name="email" class="form-control" placeholder="Email" pattern="^[A-Za-z0-9][A-Za-z0-9\.-_]*[A-Za-z0-9]*@([A-Za-z0-9]+([A-Za-z0-9-]*[A-Za-z0-9]+)*\.)+[A-Za-z]*$"/>
        </div>
    </div>
    </#if>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">User Name : </label>
        <div class="com-sm-10">
            <input type="text" name="username" class="form-control" placeholder="User name"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password : </label>
        <div class="com-sm-10">
            <input type="password" name="password" class="form-control" placeholder="Password"/>
        </div>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm>
        <button type="submit" class="btn btn-outline-success">
            <a href="/registration">Sign Up</a>
        </button>&nbsp&nbsp
    </#if>
    <button class="btn btn-primary" type="submit"><#if isRegisterForm>Create<#else>Sign In</#if></button>
</form>
</#macro>

<#macro logout>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Log In</button>
</form>
</#macro>