package lesson07;

public class MainGitAdv {
    // Git advanced.

/*
    HOMEWORK.

    Внешний репозиторий:
    https://github.com/JemmUA/Hillel_Homeworks.git

1. PullRequests.
2. Исключения для ветки main.
3. Использование команды stash:

    git checkout main

    Работаем в ветке main.
    Нужно внести изменеия в ветке develop и залить в main, после чего продолжить работу в ветке main. Но merge делать не будем, что бы не нарушить пулреквесты для первого задания.
    Прячем наработки.

    git stash save mainBranch

    Проверяем список stash

    git stash list

    В списке stash одна позиция:
    stash@{0}: On main: mainBranch
    Идем в develop.

    git checkout develop

    Делаем некие необходимые изменения.
    Для демо списка stash делаем stash в ветке develop и возвращаем тут же c удалением pop, делаем push с текущей ветки.

    git stash

    Изменеия прячутся.

    git stash list

    В списке stash теперь две позиции:
    stash@{0}: WIP on develop: 741d0c0 Change in branch develop
    stash@{1}: On main: mainBranch
    Возвращаем изменения в develop.

    git stash pop 0

    ...
    Dropped refs/stash@{0} (04176fa945af7f159a135d3f6775db9df39ed37d)
    Делаем commit и push

    git commit -am “add some necessary changes to develop”
    git push origin develop

    Здесь надо было бы вернуться в main и сделать git merge develop (из-за чего типа весь сырбор), но мы сейчас не будем портить мержреквесты.

    Возвращаемся в main.

    Достаем изменения для ветки main (после pop в develop они остались единственные).
    Тоже самое можно было сделать последовательным выполнением команд apply (применить) и drop (удалить).

    git checkout main
    git stash pop 0

    ...
    Dropped refs/stash@{0} (0215447cecd25889981faff9d174e403c9aa1d20)
    Изменения вернулись. Все супер, можем продолжать работу )


4. Использование cherry-pick.

    Работаем в ветке develop.
    1.Испекаем торт :) в файлике cherry-pickMe. Индексируем,коммитим, пушим.

    git add .
    git commit -m "bake a cake"
    git push origin develop

    2. Теряем тортик. Индексируем/коммитим, пушим.

    git commit -am "lose the cake"
    git push origin develop

    3. Но так как без тортика не можем - идем на поиски.

    git log -5 --oneline

    88c3d29 (HEAD -> develop, origin/develop) lose the cake
    a0ff0da bake a cake
    0adf49f Merge branch 'develop' of https://github.com/JemmUA/Hillel_Homeworks into develop
    a21d68c add some necessary changes to develop
    a7c8baf add some neccesary changes to develop
    Находим! Хеш a0ff0da. Тянем за вишенку )))

    git cherry-pick a0ff0da --no-commit

    Индексируем/коммитим, пушим.

    git commit -am "restore cake - commit a0ff0da"
    git push origin develop

    Приятного аппетита! :)
    */

    //
}
