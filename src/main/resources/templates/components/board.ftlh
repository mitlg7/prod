<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<#import 'skeleton.ftlh' as component>

<@component.skeleton title="Авторизация">
    <#import 'navbar.ftlh' as bootstrap>

    <@bootstrap.navbar/>
    <form class="container col-8" method="post" action="sclad">

    </form>

</@component.skeleton>