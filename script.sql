USE [master]
GO
/****** Object:  Database [PKDK]    Script Date: 07/05/2022 11:42:54 ******/
CREATE DATABASE [PKDK] ON  PRIMARY 
( NAME = N'PKDK', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\PKDK.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PKDK_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\PKDK_log.LDF' , SIZE = 576KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PKDK] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PKDK].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PKDK] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [PKDK] SET ANSI_NULLS OFF
GO
ALTER DATABASE [PKDK] SET ANSI_PADDING OFF
GO
ALTER DATABASE [PKDK] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [PKDK] SET ARITHABORT OFF
GO
ALTER DATABASE [PKDK] SET AUTO_CLOSE ON
GO
ALTER DATABASE [PKDK] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [PKDK] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [PKDK] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [PKDK] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [PKDK] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [PKDK] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [PKDK] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [PKDK] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [PKDK] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [PKDK] SET  ENABLE_BROKER
GO
ALTER DATABASE [PKDK] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [PKDK] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [PKDK] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [PKDK] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [PKDK] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [PKDK] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [PKDK] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [PKDK] SET  READ_WRITE
GO
ALTER DATABASE [PKDK] SET RECOVERY SIMPLE
GO
ALTER DATABASE [PKDK] SET  MULTI_USER
GO
ALTER DATABASE [PKDK] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [PKDK] SET DB_CHAINING OFF
GO
USE [PKDK]
GO
/****** Object:  Table [dbo].[User]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [nvarchar](50) NULL,
	[Password] [char](64) NULL,
	[Role] [nvarchar](50) NULL,
 CONSTRAINT [PK__User__3214EC277F60ED59] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[User] ON
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (1, N'tieptan1', N'1                                                               ', N'TiepTan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (2, N'tieptan2', N'1                                                               ', N'TiepTan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (3, N'bacsi1', N'1                                                               ', N'BacSi')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (4, N'bacsi2', N'1                                                               ', N'BacSi')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (5, N'phatthuoc1', N'1                                                               ', N'PhatThuoc')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (6, N'phatthuoc2', N'1                                                               ', N'PhatThuoc')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (7, N'benhnhan1', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (8, N'benhnhan2', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (9, N'benhnhan', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (10, N'benhnhan8', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (11, N'benhnhan9', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (27, N'gosuisme21@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (28, N'gosuisme21@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (29, N'nguyen.vana@test.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (30, N'john.hen@test.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (40, N'buoi.nv@gmail.com', N'1                                                               ', N'BacSi')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (41, N'harry.potter328@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (42, N'minh.lq@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (43, N'quynh.tnb1602@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (44, N'john.niles@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (45, N'mm1213@gmail.com', N'1                                                               ', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (46, N'quyen.maivan@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BacSi')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (47, N'quyen.tran@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (48, N'phuocsang.dinh@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (50, N'dang.nguyenviet@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (51, N'sang.nv@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (52, N'hanhquyenle@gmail.com', N'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (53, N'sontran@gmail.com', N'6B51D431DF5D7F141CBECECCF79EDF3DD861C3B4069F0B11661A3EEFACBBA918', N'TiepTan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (54, N'bang.nh@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (56, N'crucialnq.dev21@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'TiepTan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (57, N'kh.levan@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'TiepTan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (58, N'dat.nv21@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (59, N'kha.lemi@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (60, N'hoai.dv@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (61, N'sontran@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (62, N'quyen.maivan@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (63, N'an.ngophuoc@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
INSERT [dbo].[User] ([ID], [UserID], [Password], [Role]) VALUES (64, N'thoa.lk@gmail.com', N'6B86B273FF34FCE19D6B804EFF5A3F5747ADA4EAA22F1D49C01E52DDB7875B4B', N'BenhNhan')
SET IDENTITY_INSERT [dbo].[User] OFF
/****** Object:  Table [dbo].[Thuoc]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[TenThuoc] [nvarchar](50) NULL,
	[NSX] [nvarchar](50) NULL,
	[DonViTinh] [nvarchar](50) NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[CongDung] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Thuoc] ON
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (1, N'Acid Acetylsalicylic', NULL, N'Vien', NULL, NULL, N'Giam Dau')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (2, N'Diclofenac', NULL, N'Vien', NULL, NULL, N'Giam Dau')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (3, N'Paracetamol', NULL, N'Vien', NULL, NULL, N'Giam Dau')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (4, N'Mefloquin', NULL, N'Vien', NULL, NULL, N'Phong Sot Ret')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (5, N'
Proguanil', NULL, N'Vien', NULL, NULL, N'Phong Sot Ret')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (6, N'Quinin dihydroclorid', NULL, N'Lo', NULL, NULL, N'Tri Sot Ret')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (7, N'Glyceryl trinitrat', NULL, N'Vien', NULL, NULL, N'Chong dau that nguc')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (8, N'Enalapril', NULL, N'Vien', NULL, NULL, N'Tri tang huyet ap')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (9, N'Hydroclorothiazid', NULL, N'Vien', NULL, NULL, N'Tri tang huyet ap')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (10, N'Atenolol', NULL, N'Vien', NULL, NULL, N'Tri tang huyet ap')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (11, N'Digoxin', NULL, N'VIen', NULL, NULL, N'Suy Tim')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (12, N'Furosemid', NULL, N'Vien', NULL, NULL, N'Suy Tim')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (13, N'Cimetidin', NULL, N'Vien', NULL, NULL, N'Viem,loet da day')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (14, N'Famotidin', NULL, N'Lo', NULL, NULL, N'Viem,loet da day')
INSERT [dbo].[Thuoc] ([ID], [TenThuoc], [NSX], [DonViTinh], [SoLuong], [DonGia], [CongDung]) VALUES (15, N'Ipratropium bromid', NULL, N'Lo', NULL, NULL, N'Tri hen,suyen')
SET IDENTITY_INSERT [dbo].[Thuoc] OFF
/****** Object:  Table [dbo].[NhanVien]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ho] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[NhanVien] ON
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (1, N'Le', N'Minh Thuan', CAST(0x2B050B00 AS Date), N'Quan 2, TPHCM', N'0907512377', N'minhthuan@gmail.com', 1)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (2, N'Tran', N'My Le', CAST(0x29170B00 AS Date), N'Quan 10,TPHCM', N'0934521478', N'myle@gmail.com', 2)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (3, N'Nguyen ', N'Cam Tho', CAST(0x220F0B00 AS Date), N'Quan 10,TPHCM', N'0785125478', N'camtho@gmail.com', 3)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (4, N'Le', N'Minh Hung', CAST(0xBF080B00 AS Date), N'Quan 10,TPHCM', N'0786548793', N'minhhung@gmail.com', 4)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (5, N'Ly ', N'Thi Hang', CAST(0x46190B00 AS Date), N'Quan 10,TPHCM', N'0902547896', N'hang@gmail.com', 5)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (6, N'Phan', N'Minh Tuan', CAST(0xE7180B00 AS Date), N'Quan 10,TPHCM', N'0745632817', N'tuanminh@gmail.com', 6)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (8, N'Nguyen ', N'Van Buoi', CAST(0x590D0B00 AS Date), N'Q1, HCM', N'0812321718', N'buoi.nv@gmail.com', 40)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (9, N'Mai ', N'Văn Quyền', CAST(0x09440B00 AS Date), N'Tan Phu, HCMC', N'0328191233', N'quyen.maivan@gmail.com', 46)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (10, N'Tran', N'Son', CAST(0x01440B00 AS Date), N'Tan Phu, HCMC', N'03921381111', N'sontran@gmail.com', 53)
INSERT [dbo].[NhanVien] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User]) VALUES (13, N'Lê', N'Văn Kh', CAST(0x72230B00 AS Date), N'Tân Phú, Hồ Chí Minh', N'0903003333', N'kh.levan@gmail.com', 57)
SET IDENTITY_INSERT [dbo].[NhanVien] OFF
/****** Object:  Table [dbo].[BenhNhan]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[BenhNhan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Ho] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[DiaChi] [nvarchar](50) NULL,
	[SDT] [nvarchar](50) NULL,
	[Email] [nvarchar](50) NULL,
	[Id_User] [int] NULL,
	[GioiTinh] [varchar](5) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[BenhNhan] ON
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (24, N'Tran ', N'Huynh Nhat Quang', CAST(0x3E260B00 AS Date), N'Tan Phu, HCMC', N'0981833759', N'gosuisme21@gmail.com', 27, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (25, N'A', N'aaaa', CAST(0x00440B00 AS Date), N'22', N'+84981833759', N'gosuisme21@gmail.com', 28, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (26, N'Trần', N'Jason', CAST(0xF2140B00 AS Date), N'Q1, HCM', N'0123456789', N'nguyen.vana@test.com', 29, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (27, N'John', N'Hennison', CAST(0x09440B00 AS Date), N'Tan Phu, HCMC', N'0123456789', N'john.hen@test.com', 30, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (36, N'Potter', N'Harry', CAST(0x4E210B00 AS Date), N'Q1, HCM', N'0923812138', N'harry.potter328@gmail.com', 41, N'nu')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (37, N'Le', N'Quang Minh', CAST(0xBD240B00 AS Date), N'Tan Phu, HCMC', N'0923112931', N'minh.lq@gmail.com', 42, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (38, N'Trần', N'Ngọc Bảo Quỳnh', CAST(0x7D280B00 AS Date), N'Tân Phú, Hồ Chí Minh', N'0903658446', N'quynh.tnb1602@gmail.com', 43, N'nu')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (39, N'John', N'Niles', CAST(0x831B0B00 AS Date), N'Q1, HCM', N'013212319', N'john.niles@gmail.com', 44, N'nu')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (40, N'Morales', N'Miles', CAST(0x61320B00 AS Date), N'Go Vap, HCMC', N'01616161616', N'mm1213@gmail.com', 45, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (41, N'Tran', N'Quyền', CAST(0x0B440B00 AS Date), N'Tan Phu, HCMC', N'02188235123', N'quyen.tran@gmail.com', 47, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (42, N'Đinh', N'Phước Sang', CAST(0x722B0B00 AS Date), N'Q2, HCM', N'0945456789', N'phuocsang.dinh@gmail.com', 48, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (47, N'Nguyễn', N'Viết Đặng', CAST(0x9A220B00 AS Date), N'Tan Phu, HCMC', N'09128127131', N'dang.nguyenviet@gmail.com', 50, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (58, N'Lê ', N'Hạnh Quyên', CAST(0x2A2B0B00 AS Date), N'Tan Binh, Ho Chi Minh', N'023123218', N'hanhquyenle@gmail.com', 52, N'nu')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (59, N'Nguyễn', N'Hữu Thọ', CAST(0x1F440B00 AS Date), N'Tan Phu, HCMC', N'0213823811', N'bang.nh@gmail.com', 54, N'nu')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (60, N'Nguyễn', N'Văn Đạt', CAST(0x9A220B00 AS Date), N'Tân Phú, Hồ Chí Minh', N'0908080811', N'dat.nv21@gmail.com', 58, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (61, N'Lê', N'Minh Tuấn', CAST(0x3E260B00 AS Date), N'Tân Phú, Hồ Chí Minh', N'0328191233', N'kha.lemi@gmail.com', 59, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (65, N'NgÃ´', N'PhÆ°á»c An', CAST(0x1E440B00 AS Date), N'Q1, HCM', N'0902020202', N'an.ngophuoc@gmail.com', 63, N'nam')
INSERT [dbo].[BenhNhan] ([ID], [Ho], [Ten], [NgaySinh], [DiaChi], [SDT], [Email], [Id_User], [GioiTinh]) VALUES (66, N'Lê', N'Kim', CAST(0x41210B00 AS Date), N'a', N'0123213711', N'thoa.lk@gmail.com', 64, N'nam')
SET IDENTITY_INSERT [dbo].[BenhNhan] OFF
/****** Object:  Table [dbo].[ToaThuoc]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ToaThuoc](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NgayTao] [date] NULL,
	[ChanDoan] [nvarchar](50) NULL,
	[Id_BenhNhan] [int] NULL,
	[Id_BacSi] [int] NULL,
	[Id_PhatThuoc] [int] NULL,
	[TinhTrang] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[ToaThuoc] ON
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (4, CAST(0x04440B00 AS Date), N'a', 24, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (5, CAST(0x04440B00 AS Date), N'a', 25, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (6, CAST(0x05440B00 AS Date), N'ho', 26, 9, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (7, CAST(0x05440B00 AS Date), N'a', 27, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (16, CAST(0x11440B00 AS Date), N'a', 36, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (17, CAST(0x12440B00 AS Date), N'Sá»t nháº¹', 37, 9, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (18, CAST(0x15440B00 AS Date), N'a', 38, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (19, CAST(0x15440B00 AS Date), N'a', 39, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (20, CAST(0x15440B00 AS Date), N'a', 40, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (21, CAST(0x15440B00 AS Date), N'a', 41, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (22, CAST(0x16440B00 AS Date), N'a', 42, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (29, CAST(0x17440B00 AS Date), N'a', 58, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (30, CAST(0x1D440B00 AS Date), N'a', 59, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (31, CAST(0x1D440B00 AS Date), N'a', 59, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (32, CAST(0x1D440B00 AS Date), N'a', 59, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (33, CAST(0x1D440B00 AS Date), N'a', 38, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (34, CAST(0x1D440B00 AS Date), N'a', 38, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (38, CAST(0x1D440B00 AS Date), N'a', 38, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (41, CAST(0x20440B00 AS Date), N'a', 60, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (45, CAST(0x21440B00 AS Date), N'a', 61, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (46, CAST(0x21440B00 AS Date), N'a', 38, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (50, CAST(0x22440B00 AS Date), N'a', 65, 1, 1, 0)
INSERT [dbo].[ToaThuoc] ([ID], [NgayTao], [ChanDoan], [Id_BenhNhan], [Id_BacSi], [Id_PhatThuoc], [TinhTrang]) VALUES (51, CAST(0x23440B00 AS Date), N'a', 66, 1, 1, 0)
SET IDENTITY_INSERT [dbo].[ToaThuoc] OFF
/****** Object:  Table [dbo].[ToaThuocChiTiet]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ToaThuocChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_ToaThuoc] [int] NULL,
	[ID_Thuoc] [int] NULL,
	[SoLuong] [int] NULL,
	[DonGia] [float] NULL,
	[Sang] [nvarchar](50) NULL,
	[Chieu] [nvarchar](50) NULL,
	[Toi] [nvarchar](50) NULL,
	[CachDung] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_ToaThuoc] [int] NULL,
	[NgayTao] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonChiTiet]    Script Date: 07/05/2022 11:42:54 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonChiTiet](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ID_HoaDon] [int] NULL,
	[DichVu] [nvarchar](50) NULL,
	[DonGia] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  ForeignKey [FK__NhanVien__Id_Use__08EA5793]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK__NhanVien__Id_Use__08EA5793] FOREIGN KEY([Id_User])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK__NhanVien__Id_Use__08EA5793]
GO
/****** Object:  ForeignKey [FK__BenhNhan__Id_Use__0DAF0CB0]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[BenhNhan]  WITH CHECK ADD  CONSTRAINT [FK__BenhNhan__Id_Use__0DAF0CB0] FOREIGN KEY([Id_User])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[BenhNhan] CHECK CONSTRAINT [FK__BenhNhan__Id_Use__0DAF0CB0]
GO
/****** Object:  ForeignKey [FK__ToaThuoc__Id_Bac__1367E606]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[ToaThuoc]  WITH CHECK ADD FOREIGN KEY([Id_BacSi])
REFERENCES [dbo].[NhanVien] ([ID])
GO
/****** Object:  ForeignKey [FK__ToaThuoc__Id_Ben__1273C1CD]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[ToaThuoc]  WITH CHECK ADD FOREIGN KEY([Id_BenhNhan])
REFERENCES [dbo].[BenhNhan] ([ID])
GO
/****** Object:  ForeignKey [FK__ToaThuoc__Id_Pha__145C0A3F]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[ToaThuoc]  WITH CHECK ADD FOREIGN KEY([Id_PhatThuoc])
REFERENCES [dbo].[NhanVien] ([ID])
GO
/****** Object:  ForeignKey [FK__ToaThuocC__ID_Th__1A14E395]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[ToaThuocChiTiet]  WITH CHECK ADD FOREIGN KEY([ID_Thuoc])
REFERENCES [dbo].[Thuoc] ([ID])
GO
/****** Object:  ForeignKey [FK__ToaThuocC__ID_To__1920BF5C]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[ToaThuocChiTiet]  WITH CHECK ADD FOREIGN KEY([ID_ToaThuoc])
REFERENCES [dbo].[ToaThuoc] ([ID])
GO
/****** Object:  ForeignKey [FK__HoaDon__ID_ToaTh__1ED998B2]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([ID_ToaThuoc])
REFERENCES [dbo].[ToaThuoc] ([ID])
GO
/****** Object:  ForeignKey [FK__HoaDonChi__ID_Ho__239E4DCF]    Script Date: 07/05/2022 11:42:54 ******/
ALTER TABLE [dbo].[HoaDonChiTiet]  WITH CHECK ADD FOREIGN KEY([ID_HoaDon])
REFERENCES [dbo].[HoaDon] ([ID])
GO
