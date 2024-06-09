import { Component } from '@angular/core';
import { FormControl, FormsModule } from '@angular/forms';
import { AddSomethingNewComponent } from '../../../components/add-something-new/add-something-new.component';
import { VarsService } from '../../../global/vars/vars.service';
import { Menu } from '@bean/Menu';
import { MenuTemplate } from '@bean/MenuTemplate';
import { MenuSize } from '@bean/MenuSize';
import { MenuPrice } from '@bean/MenuPrice';
import { MenuService } from '@service/Menu.service';
import { MenuTemplateService } from '@service/MenuTemplate.service';
import { MenuPriceService } from '@service/MenuPrice.service';
import { CommonModule } from '@angular/common';
import { Category } from '@bean/Category';
import { Type } from '@bean/Type';
import { CategoryService } from '@service/Category.service';
import { MenuSizeService } from '@service/MenuSize.service';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { UserGroup } from '@bean/UserGroup';
import { auto } from '@popperjs/core';
@Component({
  selector: 'app-menus',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatSelectModule, CommonModule, FormsModule, AddSomethingNewComponent],
  templateUrl: './menus.component.html',
  styleUrl: './menus.component.scss'
})
export class MenusComponent {
  public add_menu_modal_data = {
    name: "Add menu",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Add",
    cancel: "Cancel",
  }
  public register_menuSize_modal_data = {
    name: "Register menu size",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Register",
    cancel: "Cancel",
  }

  public register_menu_modal_data = {
    name: "Register menu",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Register",
    cancel: "Cancel",
  }
  public register_category_modal_data = {
    name: "Register Category",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Register",
    cancel: "Cancel",
  }

  public tmpMenuTemplate: MenuTemplate = new MenuTemplate();
  public tmpMenu: Menu = new Menu();
  public tmpSearchMenu: Menu = new Menu();
  public tmpMenuPrice: MenuPrice = new MenuPrice();
  public tmpCategory: Category = new Category();
  public tmpMenuSize: MenuSize = new MenuSize();
  public tmpRecievableEmployeeGroupIds = new FormControl("");
  public filterMenu_Name = ""
  public filterCategory_Name: Category = new Category();
  public newCategory: Category = new Category();

  constructor(public menuSizeService: MenuSizeService, public categoryService: CategoryService, public vars: VarsService, private menuPriceService: MenuPriceService, public menuService: MenuService, private menuTemplateService: MenuTemplateService) {
  }
  ngAfterContentInit() {
    this.resetAllData()
    this.tmpMenuSize.category = this.vars.getMenuCategories().values().next().value
    this.tmpMenu.menuSize = this.vars.getMenuSizes().values().next().value;
    this.tmpMenuTemplate.category = this.vars.getMenuCategories().values().next().value
    this.newCategory.name = ""
    this.filterCategory_Name = this.newCategory
  }


  registerCategory() {
    this.tmpCategory.type = this.vars.getTypes().get("menu_category")!
    if (this.tmpCategory.name != ""
      && this.tmpCategory.type != undefined
      && ([...this.vars.getMenuCategories().values()].filter((a) => { return a.name == this.tmpCategory.name }).length == 0)) {
      let tmp = new Array<UserGroup>();
      for (let a of this.tmpRecievableEmployeeGroupIds) {
        let b = new UserGroup();
        b.id = a
        tmp.push(b)
      }
      this.tmpCategory.recieveUserGroups = tmp
      this.categoryService.createCategory(this.tmpCategory).subscribe((data) => {
        if (data != null) {
          this.vars.getMenuCategories().set(data.name, data)
          this.register_category_modal_data.ERROR_MESSAGE = ""
          this.resetAllData()
        }
      })
    } else {
      this.register_category_modal_data.ERROR_MESSAGE = "Category name cannot empty or duplicate"
    }
  }
  editCategory() {

  }
  deleteCategory(categoryId: number, categoryName: string) {
    this.categoryService.deleteCategory(categoryId).subscribe()
    this.vars.getMenuCategories().delete(categoryName)
  }

  filterCategory() {
    return [... this.vars.getMenuCategories().values()].filter((a) => {
      return a.name.includes(this.tmpCategory.name ?? "")
    })
  }



  register_menu() {
    if (this.filterMenuTemplate().length == 0) {
      this.menuTemplateService.createMenuTemplate(this.tmpMenuTemplate).subscribe((data) => {
        if (data != null) {
          this.resetAllData()
          this.vars.addMenuTemplate(data);
        }
        else {
          this.register_menu_modal_data.ERROR_MESSAGE = "Something went wrong."
        }
      },
        (error) => {
          this.register_menu_modal_data.ERROR_MESSAGE = "Server error"
        }
      )
    }
  }

  filterMenuTemplate() {
    return this.vars.getMenuTemplates().filter((data: MenuTemplate) => {
      if (this.tmpMenuTemplate.category != null) {
        return data.name.includes(this.tmpMenuTemplate.name ?? "") && data.category.id == this.tmpMenuTemplate!.category.id
      }
      else {
        return false
      }
    })

  }

  editMenuTemplate() {

  }
  deleteMenuTemplate(id: number) {
    this.menuTemplateService.deleteMenuTemplate(id).subscribe((data) => {
      if (data != false) {
        this.vars.deleteMenuTemplate(id)
        this.register_menu_modal_data.ERROR_MESSAGE = ""
      }
      else {
        this.register_menu_modal_data.ERROR_MESSAGE = "There are entities created from this menu."
      }
    });

  }


  filterMenu() {
    return [...this.vars.getMenus().values()].filter((data: Menu) => {
      if (this.filterCategory_Name.name != "") {
        return data.menuTemplate.name.includes(this.filterMenu_Name) && (data.menuTemplate.category.id == this.filterCategory_Name.id)
      }
      else {
        return true
      }

    })

  }

  addMenu() {
    if (this.tmpMenu.menuSize.category != null && this.tmpMenu.menuSize.category.id == this.tmpMenu.menuTemplate.category.id) {

      if ([...this.vars.getMenus().values()].filter((data: Menu) => {
        return data.menuTemplate.id == this.tmpMenu.menuTemplate.id && data.menuSize.id == this.tmpMenu.menuSize.id
      }).length == 0) {
        this.menuService.createMenu(this.tmpMenu).subscribe((data) => {
          if (data != null) {
            this.tmpMenuPrice.menu = new Menu()
            this.tmpMenuPrice.menu.id = data.id
            this.tmpMenuPrice.restaurant = this.vars.getCurrentRestaurant()
            this.menuPriceService.createMenuPrice(this.tmpMenuPrice).subscribe((data) => {
              if (data != null) {
                this.tmpMenuPrice = data
              }
            })
            data.menuPrices = [this.tmpMenuPrice]
            this.vars.addMenu(data)
            this.resetAllData()
            this.add_menu_modal_data.show = false
          }
        })
      } else {
        this.add_menu_modal_data.ERROR_MESSAGE = "Menu already exists"
      }
    }
    else {
      this.add_menu_modal_data.ERROR_MESSAGE = "Please choose menu size "
    }
  }
  editMenu() {

  }
  deleteMenu(menuId: number) {
    this.menuService.deleteMenu(menuId).subscribe();
    this.vars.deleteMenu(menuId)
  }


  deleteMenuSize(menuSizeId: number) {
    this.menuSizeService.deleteMenuSize(menuSizeId).subscribe((data) => {
      if (data == true) {
        this.vars.getMenuSizes().delete(menuSizeId)
      } else {
        this.register_menuSize_modal_data.ERROR_MESSAGE = "Something went wrong."
      }
    })
  }
  filterMenuSize() {
    return [...this.vars.getMenuSizes().values()].filter((a) => {
      if (this.tmpMenuSize.category != undefined) {
        return a.name.includes(this.tmpMenuSize.name ?? "") && a.category.id == this.tmpMenuSize!.category.id
      }
      else {
        return false
      }
    })
  }

  newMenuSizeObject = new MenuSize()
  filterMenuSizeAddMenu() {
    this.newMenuSizeObject.name = ""
    let tmp = [...this.vars.getMenuSizes().values()].filter((a) => {
      if (this.tmpMenu.menuTemplate != undefined && this.tmpMenu.menuTemplate.category != undefined) {
        return a.category.id == this.tmpMenu.menuTemplate.category.id
      }
      else {
        return false
      }
    })

    return tmp;
  }

  registerMenuSize() {
    if (this.tmpMenuSize.name == "") {
      this.register_menuSize_modal_data.ERROR_MESSAGE = "Menu size cannot empty.";
    } else {
      if ([...this.vars.getMenuSizes().values()].filter((a) => {
        if (a.name == this.tmpMenuSize.name) {
          if (a.category.id == this.tmpMenuSize.id) {
            return true;
          } else {
            return false;
          }
        } else {
          return false;
        }
      }).length == 0) {
        this.menuSizeService.createMenuSize(this.tmpMenuSize).subscribe((data) => {
          this.vars.getMenuSizes().set(data.id, data)
          this.resetAllData()
        });
      } else {
        this.register_menuSize_modal_data.ERROR_MESSAGE = "Menu size already exists."
      }
    }
  }


  resetAllData() {
    //this.tmpCategory = new Category();
    this.tmpCategory.name = ""

    //this.tmpMenuTemplate = new MenuTemplate();
    this.tmpMenuTemplate.name = ""

    //this.tmpMenu = new Menu();
    this.tmpMenu.menuTemplate = this.vars.getMenuTemplates().at(0)!;
    this.tmpMenu.menuSize = this.vars.getMenuSizes().values().next().value;


    //this.tmpRecievableEmployeeGroupIds = new Array<number>();

    this.tmpSearchMenu.menuTemplate = new MenuTemplate();
    this.tmpSearchMenu.menuTemplate.name = ""
    this.tmpMenuPrice = new MenuPrice();

    //this.tmpMenuSize = new MenuSize();
    this.tmpMenuSize.name = ""

    //this.tmpMenuSize.category = this.vars.getMenuCategories().values().next().value
    //this.tmpMenuTemplate.category = this.vars.getMenuCategories().values().next().value

    this.register_menu_modal_data.ERROR_MESSAGE = ""
    this.register_category_modal_data.ERROR_MESSAGE = ""
    this.add_menu_modal_data.ERROR_MESSAGE = ""
    this.register_menuSize_modal_data.ERROR_MESSAGE = ""


  }

}



