<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Страница пользователя">
    <@bootstrap.navbar/>
    <div class="container">
        Страница пользователя
        ${user.login} <br>
        ${user.email} <br>
        ${user.role} <br>
        <#if userInfo??>
            ${userInfo.name}<br>
            ${userInfo.lastName}<br>
            ${userInfo.phone}<br>
            ${userInfo.image}<br>
            ${userInfo.birthday}<br>
        </#if>
    </div>

</@component.skeleton>