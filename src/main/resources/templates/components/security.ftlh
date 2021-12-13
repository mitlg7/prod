<#assign
known = Session.SPRING_SECURITY_CONTEXT??
>
<#if known>
    <#assign
    principal = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = principal.username
    >
</#if>
