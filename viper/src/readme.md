----------------------------------------------------------------------->>> git 开始 <<<-----------------------------------------------------------------------

Git提交规范:
    Fix: 修复bug
    Feat: 增加新功能
    docs: 文档（documentation）
    style: 格式（不影响代码运行的变动）
    refactor: 重构（即不是新增功能，也不是修改bug的代码变动）
    test: 增加测试
    chore: 构建过程或辅助工具的变动 
    
git命令:
    1.git设置用户名和邮箱
        git config --global user.name  "GitHub的用户名"
        git config --global user.email "邮箱"
    2.查看git的配置
        git config --list  或者 git config -l 
    3.查看文件内容
        cat 文件名
    4.生成 / 编辑文件
        vim 文件名  按i可以编辑，保存或者退出先按esc，然后输入命令wq是保存并退出，q!退出不保存。 
    5.文件,文件夹在工作区、暂存区的状态
        git status
    6.查看提交(commit)历史
        git log (显示所有提交过的版本信息如果觉得太繁琐，可以加上参数--pretty=oneline，只显示版本号和提交备注)
        git reflog(可以查看所有分支的所有操作记录（包括已经被删除的 commit 记录和 reset 的操作）)
    7.将文件添加至暂存区
        git add 文件名
    8.将文件添加至本地仓库
        git commit -m "描述"
    9.新修改的文件还没有add , 回退操作命令
        git checkout -- file(文件名)
    10.修改的文件add了，回退操作命令
        git reset head 文件名      
    	git checkout -- file(文件名)
    11.修改的文件add，commit了，回退操作命令
        git log查看提交历史，记住[commit id]
        git reset --hard id(前七位就行)
    12.已经push的代码，进行回退
        git log 查看提交历史，记住[commit id]
    	git reset --hard [commit id(前七位就行)]
    	这个时候只是回退了本地仓库的代码，远程的代码还没有回退。需要强制推送到远程
    	git push [-f -u] origin 远程分支名(例如develop)
    13.删除文件
        git rm 文件名
    	(移除后的文件可以git reset head file回退)
        git commit -m "删除描述"
    14.创建新分支
        git branch 分支名
    15.切换分支
        git checkout 分支名	
    16.删除分支
        git branch -d 分支名
    17.删除远程分支
        git push origin -d 分支名
    18.查看分支
        git branch -a  查看所有分支
        git branch     查看本地分支
        git branch -r  查看远程分支
    19.创建并切换分支
        git checkout -b 分支名
    20.创建SSHKey
        ssh-keygen -t ras -C "1729375118@qq.com" 一直enter就行了。
    	cat ~/.ssh/id_rsa.pub(查看生成的秘钥)
    	在github 中找到 SSH and GPG Keys  选择New SSH key将生成的秘钥放入key就行
    21.将本地项目推送到远程当做远程仓库
        1将本地项目初始化  git init 
    	2将所有文件add ，commit 
    	3在远程创建同名的空仓库
    	4将本地仓库与远程空仓库联系
    	    git remote add origin git@github.com:LiGouDan/java2013.git
        5将本地仓库推送到远程
    	    git push -u origin master 
----------------------------------------------------------------------->>> git 结束 <<<-----------------------------------------------------------------------

----------------------------------------------------------------------->>> MYSQL 开始 <<<-----------------------------------------------------------------------

explain:
    id:
        Id 相同时，执行顺序从上到下
        Id 不同时：id越大的越先执行
        Id 相同不同时，先执行大的，然后从上往下执行
        如果是子查询，id会递增，id越大表明优先级越高，越先执行
    select_type:
        Simple : 简单的select查询，不包含子查询和union查询
        Primary: 最后加载的那个查询表
        Subquery : 在select或者where列表中包含子查询
        Derived: 临时表，在from列表中包含的子查询被标记为derived(衍生)mysql会递归执行这些子查询，把结果放在临时表里。
        Union：若第二个select在union之后，会被标记为union.
        Union result : 从union表中获取结果的select
    table:
        表明执行的是那个表
    partitions:
        分区使用的
    type:
        访问类型排序：System > const > eq_ref > ref > range > index > ALL
    possible_keys：
        理论上用到了多少索引
    key:
        实际上用到了多少索引
    key_len:
    ref:
        表示查询时用于匹配的字段或常量，常见的 ref 值:
            const：查询使用常量值
            NULL：
            索引列名：查询使用了索引列
            FUNC：查询使用了函数
            表的列名：表示表连接条件使用的字段
    rows:
        表示MySQL在执行查询时需要扫描的行数，数值越小越好
    filtered:
        表示MySQL在执行查询时，基于查询条件(如 WHERE 子句)的过滤比例。它的值是一个百分比，表示查询返回的行中，符合条件的行所占的比例，数值越大越好
    Extra：
        Using filesort: 说明mysql会对数据使用一个外部的索引排序，而不是按照表内的索引进行排序。Mysql中无法利用索完成的排序操作叫文件排序
            Select * from user where name = ‘张三’ order by sex;(name,age,sex这三个建立了复合索引)
        Using temporary:  使用了临时表保存了中间结果，Mysql在对查询结果排序时使用了临时表。常见于排序order by 和分组group by
        
覆盖索引(索引覆盖)：
    简单理解为就是查询的列和索引列相同 
    覆盖索引最好不用select * 

索引失效:
    1.范围以后的索引会失效
        select id, name, age from user where name = ‘张三’ and age > 10 ,(如果name 和 age建立了索引，但是此时索引会失效) 
    2.使用不等于时!= <>
    3.使用is null is not null
    4.使用like时左边有%
    5.varchar类型 不加单引号索引会失效
    6.排序规则不一致
    
常用sql:
    1.查询最大的verchar类型的id
        SELECT
            MAX(
            CONVERT ( column_name, SIGNED )) 
        FROM
            table_name;
    2.查询库中所有没有primary key的表名
        SELECT
            table_name 
        FROM
            information_schema.TABLES 
        WHERE
            table_schema = 'viper' 
            AND table_name NOT IN ( SELECT table_name FROM information_schema.table_constraints WHERE constraint_type = 'PRIMARY KEY' AND table_schema = 'viper' );
    3.查询自定义的函数名称
        SELECT
            routine_name 
        FROM
            information_schema.routines 
        WHERE
            routine_type = 'FUNCTION' 
            AND routine_schema = 'viper';
    4.查询表的排序规则
        SELECT
            table_name,
            table_collation 
        FROM
            information_schema.TABLES 
        WHERE
            table_schema = 'viper';
    5.查询不是utf8mb4_general_ci排序的表名
        SELECT
            table_name,
            table_collation 
        FROM
            information_schema.TABLES 
        WHERE
            table_schema = 'viper' 
            AND table_collation != 'utf8mb4_general_ci';
    6.查询没有注释的表字段信息
        SELECT
            table_name,
            column_name 
        FROM
            information_schema.COLUMNS 
        WHERE
            table_schema = 'viper' 
            AND column_comment = '' 
            AND table_name NOT LIKE 'mysql%' -- 排除系统表
            AND table_name NOT LIKE 'information_schema%' -- 排除信息模式表
        ORDER BY
            table_name,
            ordinal_position;
    7.查询自定义的存储过程
        SELECT
            ROUTINE_NAME 
        FROM
            information_schema.routines 
        WHERE
            ROUTINE_SCHEMA = 'viper' 
            AND ROUTINE_TYPE = 'PROCEDURE';
    8.查询自定义的触发器
        SELECT
            TRIGGER_NAME as '触发器名称',
            EVENT_MANIPULATION as '触发事件',
            EVENT_OBJECT_TABLE as '触发的表',
            ACTION_STATEMENT as '触发器执行的动作'
        FROM
            information_schema.TRIGGERS 
        WHERE
            TRIGGER_SCHEMA = 'viper';
    9.查询自定义的视图
        SELECT
            TABLE_NAME,
            VIEW_DEFINITION
        FROM
            information_schema.views 
        WHERE
            TABLE_SCHEMA = 'viper';
    10.查询数据库中所有的索引情况
        SELECT
            TABLE_NAME,
            INDEX_NAME,
            GROUP_CONCAT( COLUMN_NAME ORDER BY SEQ_IN_INDEX ) AS INDEX_COLUMNS 
        FROM
            information_schema.statistics 
        WHERE
            TABLE_SCHEMA = 'viper' 
        GROUP BY
            TABLE_NAME,
            INDEX_NAME;
    11.查询表没有注释的表名(不是字段没有注释)
        SELECT
            table_name 
        FROM
            information_schema.TABLES 
        WHERE
            table_schema = 'viper' 
            AND table_comment = '' 
            AND table_name NOT LIKE 'mysql%' -- 排除系统表
                AND table_name NOT LIKE 'information_schema%' -- 排除信息模式表
        ORDER BY
            table_name;
    12.查询没有create_time或者update_time的表名
        SELECT table_name
        FROM information_schema.tables t
        WHERE t.table_schema = 'viper'
          AND (
              NOT EXISTS (
                  SELECT 1
                  FROM information_schema.columns c
                  WHERE c.table_schema = t.table_schema
                    AND c.table_name = t.table_name
                    AND c.column_name = 'create_time'
              )
              OR NOT EXISTS (
                  SELECT 1
                  FROM information_schema.columns c
                  WHERE c.table_schema = t.table_schema
                    AND c.table_name = t.table_name
                    AND c.column_name = 'update_time'
              )
          )
          AND t.table_name NOT LIKE 'mysql%'  -- 排除系统表
          AND t.table_name NOT LIKE 'information_schema%'  -- 排除信息模式表
        ORDER BY t.table_name;
    13.查询有保留字段的表
        SELECT
            TABLE_NAME,
            COLUMN_NAME 
        FROM
            INFORMATION_SCHEMA.COLUMNS 
        WHERE
            TABLE_SCHEMA = 'viper' 
            AND column_name IN ( "month", "year" );
    14.查询所有字段为char且长度大于20的
        SELECT 
            TABLE_NAME, 
            COLUMN_NAME, 
            CHARACTER_MAXIMUM_LENGTH
        FROM 
            INFORMATION_SCHEMA.COLUMNS
        WHERE 
            DATA_TYPE = 'char'
            AND CHARACTER_MAXIMUM_LENGTH > 20
            AND TABLE_SCHEMA = 'viper';
    15.查询有enum类型的表
        SELECT 
            TABLE_NAME, 
            COLUMN_NAME
        FROM 
            INFORMATION_SCHEMA.COLUMNS
        WHERE 
            DATA_TYPE = 'enum'
            AND TABLE_SCHEMA = 'viper';
    16.查询字段超过40的表
        SELECT
            TABLE_NAME,
            COUNT(*) AS '字段数量' 
        FROM
            INFORMATION_SCHEMA.COLUMNS 
        WHERE
          TABLE_SCHEMA = 'viper'
        GROUP BY
            TABLE_SCHEMA,
            TABLE_NAME 
        HAVING
            COUNT(*) > 40;
    17.查询primarykey大于两个的
        SELECT
            TABLE_NAME,
            COUNT( COLUMN_NAME ) AS PRIMARY_KEY_COLUMNS 
        FROM
            INFORMATION_SCHEMA.KEY_COLUMN_USAGE 
        WHERE
            CONSTRAINT_NAME = 'PRIMARY' 
            AND TABLE_SCHEMA = 'viper' 
        GROUP BY
            TABLE_NAME 
        HAVING
            PRIMARY_KEY_COLUMNS > 2;
    18.查询表字段注释中包含中文的全角引号的表信息
        SELECT 
            TABLE_NAME,
            COLUMN_NAME,
            COLUMN_COMMENT
        FROM 
            INFORMATION_SCHEMA.COLUMNS
        WHERE 
            COLUMN_COMMENT LIKE '%“%' OR COLUMN_COMMENT LIKE '%”%'
            AND TABLE_SCHEMA = 'viper';
    19.复合索引列数大于4的
        SELECT 
            TABLE_NAME,
            INDEX_NAME,
            COUNT(COLUMN_NAME) AS INDEX_COLUMNS
        FROM 
            INFORMATION_SCHEMA.STATISTICS
        WHERE 
            TABLE_SCHEMA = 'viper'
        GROUP BY 
            TABLE_NAME,
            INDEX_NAME
        HAVING 
            INDEX_COLUMNS > 4; 
    20.查询每张表索引的数量
        SELECT 
            TABLE_NAME,
            COUNT(DISTINCT INDEX_NAME) AS INDEX_COUNT
        FROM 
            INFORMATION_SCHEMA.STATISTICS
        WHERE 
            TABLE_SCHEMA = 'viper'  -- 指定数据库名称
        GROUP BY 
            TABLE_NAME;
    21.查询所有字段为varchar且长度大于2000的
        SELECT
            TABLE_NAME,
            COLUMN_NAME,
            CHARACTER_MAXIMUM_LENGTH 
        FROM
            INFORMATION_SCHEMA.COLUMNS 
        WHERE
            DATA_TYPE = 'varchar' 
            AND CHARACTER_MAXIMUM_LENGTH > 2000 
            AND TABLE_SCHEMA = 'viper';
    22.查询外键情况
        SELECT
            TABLE_NAME,
            CONSTRAINT_NAME,
            COLUMN_NAME,
            REFERENCED_TABLE_NAME,
            REFERENCED_COLUMN_NAME 
        FROM
            INFORMATION_SCHEMA.KEY_COLUMN_USAGE 
        WHERE
            TABLE_SCHEMA = 'viper' 
            AND REFERENCED_TABLE_NAME IS NOT NULL;
            
----------------------------------------------------------------------->>> MYSQL 结束 <<<-----------------------------------------------------------------------    

----------------------------------------------------------------------->>> excel 开始 <<<-----------------------------------------------------------------------

添加删除线:
    ctrl + 5 (windows)
    cmd + Shift + x（Mac)
    右键 -> 设置单元格格式 -> 字体 -> 删除线

----------------------------------------------------------------------->>> excel 结束 <<<-----------------------------------------------------------------------

----------------------------------------------------------------------->>> 路亚 开始 <<<-----------------------------------------------------------------------

路亚竿硬度从软到硬排名：
    UL (Ultra Light)：极软，适合非常轻的路亚和小型鱼类。非常敏感，适用于极轻的钓饵和非常细的线。
    L (Light)：比UL稍硬，适合小型鱼类和较轻的路亚。适用于细线和轻钓饵的场合。
    ML (Medium Light)：硬度比L稍强，适合中小型鱼类和轻型路亚。具有较好的灵活性和感知力。
    M (Medium)：中等硬度，适合大多数中型鱼类和标准路亚。是最常见的硬度，适合各种常规钓鱼场合。
    MH (Medium Heavy)：比M硬，适合较大鱼类和较重的路亚。适用于更强的力量要求，通常用于中等至大型鱼类。
    H (Heavy)：硬度较大，适合大型鱼类和重型路亚。能够提供强大的支撑力和控制力。
    XH (Extra Heavy)：硬度最高，适合极大鱼类和超重路亚。通常用于大物猎鱼或需要极强力量的场合。
    总结：硬度从软到硬的排名为：UL < L < ML < M < MH < H < XH。

----------------------------------------------------------------------->>> 路亚 结束 <<<-----------------------------------------------------------------------   