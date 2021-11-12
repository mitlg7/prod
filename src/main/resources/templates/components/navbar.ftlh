<#macro navbar>
    <#include "security.ftlh">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Главная</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse ml-7" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/login">Логин</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/registration">рега</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/user/user-info">добавить юзер инфо</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/user">ЛК</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="/product/create">Добавить продукт</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="#">Склад</a>
                    </li>

                </ul>
                <#if known??>
                    <div class="nav-item">
                        <a class="text-white" href="#">${name}</a>
                    </div>
                </#if>
            </div>
        </div>
    </nav>

</#macro>