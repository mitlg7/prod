<#import "components/skeleton.ftlh" as component>
<#import "components/navbar.ftlh" as bootstrap>

<@component.skeleton title="Главная страница">
    <@bootstrap.navbar/>

    <form class="container col-8" method="post" enctype="multipart/form-data"  accept="image/*">
        <div class="form-group">
            <label for="productname">Название продукта </label>
            <input name="name" minlength="5" maxlength="20" type="text" class="form-control" id="productname"
            placeholder="Название">
        </div>
        <div class="form-group">
            <label for="image" class="form-label">Фото продукта</label>
            <input name="image" id="image" type="file" accept="image" class="form-control" placeholder="Фото профиля">
        </div>
        <div class="form-group">
            <label for="description">Описание: </label>
            <input name="description" minlength="5" maxlength="250" type="text" class="form-control" id="description"
            placeholder="Описание">
        </div>
        <div class="form-group">
            <label for="price">Цена </label>
            <input name="price"  type="number" min="0" class="form-control" id="price"
                   placeholder="Цена">
        </div>
        <div class="form-group">
            <label for="price">Категория </label>
            <select class="form-control" name="categoryId" >
                <#list categories as cat>
                    <option value="${cat.id}">${cat.type}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="price">Страна производства: </label>
            <select class="form-control" name="countryId" >
                <#list countries as country>
                    <option value="${country.id}">${country.name}</option>
                </#list>
            </select>
        </div>

        <div class="row">
            <button type="submit" class="mx-auto col-8 btn btn-secondary mt-5 ">Добавить продукт</button>
        </div>
    </form>

</@component.skeleton>