<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Страница продукта">
    <@bootstrap.navbar/>
    <div class="container">
        ${product.toString()}
    </div>

</@component.skeleton>