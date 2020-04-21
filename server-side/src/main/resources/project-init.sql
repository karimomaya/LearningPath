-- docker start devenv_confdb_1
use LearningPath
go

IF OBJECT_ID('[dbo].[Account]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Account]
  END;
GO
CREATE TABLE  [dbo].[Account] (
  [id] int  NOT NULL  PRIMARY KEY IDENTITY (1, 1),
  [accountName] nvarchar(200),
  [username] nvarchar(200) NOT NULL UNIQUE,
  [email] nvarchar(255) NOT NULL UNIQUE,
  [password] nvarchar(200) NOT NULL,
  [orgId] int,
  [isActive] BIT DEFAULT 1,
  [gender] BIT
);

GO
IF OBJECT_ID('[dbo].[Organization]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Organization]
  END;
GO
CREATE TABLE Organization (
  [id] int  NOT NULL  PRIMARY KEY IDENTITY (1, 1),
  [orgName] varchar(200)  NOT NULL UNIQUE ,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1

);
GO

IF OBJECT_ID('[dbo].[FootPrint]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[FootPrint]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[FootPrint]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [footPrintCat] int NOT NULL,
  [footPrintValue] NVARCHAR(200),
  [orgId] int,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO


IF OBJECT_ID('[dbo].[FootPrintAction]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[FootPrintAction]
  END;
GO
CREATE TABLE [dbo].[FootPrintAction]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [footPrintId] INT NOT NULL,
  [accountId] int,
  [isActive] BIT DEFAULT 1,
  [description] Text,
  [createdDate] DATETIME  DEFAULT GETDATE(),
);
GO


IF OBJECT_ID('[dbo].[Category]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Category]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Category]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [catName] NVARCHAR(200) NOT NULL,
  [catParentId] int DEFAULT 0,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO

IF OBJECT_ID('[dbo].[List]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[List]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[List]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [title] NVARCHAR(255) NOT NULL,
  [accountId] int NOT NULL DEFAULT 0,
  [CategoryId] int NOT NULL,
  [rating] int,
  [privacy] INT,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO


IF OBJECT_ID('[dbo].[ListItem]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[ListItem]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[ListItem]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [name] NVARCHAR(255) NOT NULL,
  [link] NVARCHAR(max),
  [description] TEXT,
  [rating] int,
  [privacy] INT,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO



IF OBJECT_ID('[dbo].[Action]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Action]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Action]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [accountId] int NOT NULL,
  [title] nvarchar(MAX),
  [progress] int NOT NULL DEFAULT 0,
  [isActive] BIT DEFAULT 1,
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [createdDate] DATETIME  DEFAULT GETDATE()
);
GO


IF OBJECT_ID('[dbo].[ToDo]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[ToDo]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[ToDo]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [actionId] int NOT NULL,
  [name] NVARCHAR(MAX),
  [link]  NVARCHAR(MAX),
  [description] text,
  [isCompleted] BIT NOT NULL DEFAULT 0,
  [isActive] BIT DEFAULT 1,
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [createdDate] DATETIME  DEFAULT GETDATE()
);
GO



IF OBJECT_ID('[dbo].[Image]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Image]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Image]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [imagePath] NVARCHAR(max) NOT NULL,
  [relatedId] int,
  [type] int,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO



IF OBJECT_ID('[dbo].[Lookup]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[Lookup]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[Lookup]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [cat] VARCHAR(200) NOT NULL,
  [valueEng] NVARCHAR(200) NOT NULL,
  [valueAr] NVARCHAR(200) NOT NULL,
  [lookupKey] int,
  [parentId] int DEFAULT 0,
  [createdBy] int,
  [createdDate] DATETIME  DEFAULT GETDATE(),
  [modifiedDate] DATETIME  DEFAULT GETDATE(),
  [modifiedBy] int,
  [isActive] BIT DEFAULT 1
);
GO


IF OBJECT_ID('[dbo].[ErrorLog]') IS NOT NULL
  BEGIN
    DROP TABLE [dbo].[ErrorLog]
  END;
GO
-- Create the table in the specified schema
CREATE TABLE [dbo].[ErrorLog]
(
  [id] INT NOT NULL PRIMARY KEY IDENTITY (1, 1),
  [logSource] BIT NOT NULL DEFAULT 0, -- 0 server, 1: client
  [logType] int NOT NULL DEFAULT 0, -- 0: info, 1: warn, 2: error
  [message] text,
  [createdDate] DATETIME  DEFAULT GETDATE()
);
GO



INSERT INTO [dbo].[Account]
(
  [username], [email], [password], [gender], [orgId]
)
VALUES
  (
    'system', 'system@learningpath.com', '123', 0, 1
  )

GO


INSERT INTO [dbo].[Organization]
(
  [orgName], [createdBy]
)
VALUES
  (
    'shared', 1
  )

GO

INSERT INTO [dbo].[FootPrint]
(
  [footPrintCat], [footPrintValue], [orgId], [createdBy]
)
VALUES
  (
    1, 'Save Data', 1, 1
  ),
  (
    2, 'Update Data', 1, 1
  ),
  (
    3, 'Delete Data', 1, 1
  )

GO


INSERT INTO [dbo].[Lookup]
(
  [cat], [valueEng], [valueAr], [lookupKey], [createdBy], [modifiedBy]
)
VALUES
  (
    'gender', 'male', 'ذكر',  0, 1, 1
  ),
  (
    'gender', 'male', 'أنثى', 1,1,1
  )

GO
