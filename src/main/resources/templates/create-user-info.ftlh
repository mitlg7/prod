<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Личная информация">
    <@bootstrap.navbar/>
    <form class="container" method="post" action="">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="row g-3">
            <div class="col">
                <label for="name" class="form-label">Имя</label>
                <input name="name" id="name" type="text" class="form-control" placeholder="Имя" aria-label="Имя">
            </div>
            <div class="col">
                <label for="lastname" class="form-label">Фамилия</label>
                <input name="lastname" id="lastname" type="text" class="form-control" placeholder="Фамилия"
                       aria-label="Фамилия">
            </div>
        </div>
        <div class="row g-3">
            <div class="col">
                <label for="phone" class="form-label">Телефон</label>
                <input name="phone" id="phone" type="tel" class="form-control" placeholder="Телефон">
            </div>
            <div class="col">
                <label for="birthday" class="form-label">Дата рождения</label>
                <input name="birthday" id="birthday" type="date" class="form-control" placeholder="Дата рождения">
            </div>
        </div>
        <div class="row">
            <label for="image" class="form-label">Фото профиля</label>
            <input name="image" id="image" type="file" accept="image" class="form-control" placeholder="Фото профиля">
        </div>

    </form>


</@component.skeleton>