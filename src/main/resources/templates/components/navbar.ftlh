<#macro navbar>
    <#include "security.ftlh">

    <nav style="height: 60px;" class="navbar navbar-expand-lg navbar-light bg-warning">
        <a class="navbar-brand" href="#">CAR DEALER</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse text-dark" id="navbarSupportedContent">
            <ul class="navbar-nav ml-auto topnav">
                <li class="nav-item active">
                    <a class="nav-link" href="/">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/suppliers">Поставщики</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Продукты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/product/create">Добавить продукт</a>
                </li>

                <#if known??>
                    <li class="nav-item">
                        <a class="nav-link" href="/user">ЛК  ${name}</a>
                    </li>
                <#else>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Войти</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/registration">Регистрация</a>
                    </li>

                </#if>

            </ul>
        </div>

    </nav>
    <style>
        .topnav a:hover {
            border-bottom: 3px solid red;
        }

    </style>
</#macro>