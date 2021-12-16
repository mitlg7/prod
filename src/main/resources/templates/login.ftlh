<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Авторизация">
    <@bootstrap.navbar/>
    <form class="container col-8" method="post" action="login">
        <#if error??>
            <div class="alert alert-danger mt-4 col-6 text-center" role="alert">
                Данное сочетание логина и пароля не найдено.
            </div>
        </#if>
        <div class="form-group">
            <label for="username">Логин: </label>
            <input name="username" minlength="4" maxlength="32" type="text" class="form-control" id="username"
                   placeholder="Логин">
        </div>
        <div class="form-group">
            <label for="password">Пароль: </label>
            <input name="password" minlength="4" maxlength="32" type="password" class="form-control" id="password"
                   placeholder="Пароль">
        </div>
        <div class="row">
            <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Войти</button>
        </div>
    </form>

</@component.skeleton>