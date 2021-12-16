<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>

    <form method="post" action="/registration" class="container col-4 mt-5">
        <div class="form-group">
            <label for="login">Логин: </label>
            <input name="login" minlength="5"  maxlength="32" type="text" class="form-control" id="login" placeholder="Логин">
        </div>
        <div class="form-group">
            <label for="email">Почта: </label>
            <input name="email" type="email"  class="form-control" id="email" placeholder="Емаил">
        </div>
        <div class="form-group">
            <label for="password">Пароль: </label>
            <input name="password" minlength="5"  maxlength="32" type="password" class="form-control" id="password" placeholder="Пароль">
        </div>
        <div class="row">
            <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Регистрация</button>
        </div>

    </form>


</@component.skeleton>