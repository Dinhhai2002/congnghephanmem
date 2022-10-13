/**
 * 
 */
//tran content 
const $ = document.querySelector.bind(document);
const $$ = document.querySelectorAll.bind(document);

const listItem=$$(".category-list__item-link");
const listItemTB=$$(".search-item-result-on-mb-tb-link");
const ListContent=$$(".col.l-10.lo-10");



listItem.forEach((Item,index)=>{
    const content=ListContent[index];
    Item.onclick=function() {
        
        $(".col.l-10.lo-10.active").classList.remove('active');
        $(".category-list__item-link.category-list__item-link-highlight").classList.remove('category-list__item-link-highlight');
        
        this.classList.add("category-list__item-link-highlight");
        content.classList.add("active");
    };
} )

listItemTB.forEach((Item,index)=>{
    const content=ListContent[index];
    Item.onclick=function() {
        
        $(".col.l-10.lo-10.active").classList.remove('active');
        $(".search-item-result-on-mb-tb-link.category-list__item-link-highlight").classList.remove('category-list__item-link-highlight');
        
        this.classList.add("category-list__item-link-highlight");
        content.classList.add("active");
    };
} )