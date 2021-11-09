<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Страница пользователя">
    <@bootstrap.navbar/>
    <div class="container">
        Страница пользователя
        ${user.login} <br>
        ${user.email} <br>
        ${user.role} <br>
    </div>

</@component.skeleton>