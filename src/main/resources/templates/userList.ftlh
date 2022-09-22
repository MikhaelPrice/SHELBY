<#import "parts/common.ftlh" as c>

<@c.page>
List of users<br>

<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
    <tr>
        <td>${user.username} &nbsp&nbsp&nbsp&nbsp</td>
        <td><#list user.roles as role>${role} &nbsp&nbsp&nbsp&nbsp</#list></td>
        <td><button type="submit" class="btn btn-outline-info">
            <a href="/user/${user.id}">edit</a>
        </button></td>
    </tr>
    </#list>
    </tbody>
</table>
</@c.page>