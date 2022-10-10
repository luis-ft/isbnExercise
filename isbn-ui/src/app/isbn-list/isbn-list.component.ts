import { Component, OnInit } from '@angular/core';
import { isbn } from '../classes/isbn.class';
import { IsbnService } from '../services/isbn.service';

@Component({
  selector: 'app-isbn-list',
  templateUrl: './isbn-list.component.html',
  styleUrls: ['./isbn-list.component.css']
})
export class IsbnListComponent implements OnInit {

  isbnList: isbn[] = [
    { StrIsbn: "" }
  ];

  constructor(private isbnService: IsbnService) { }

  ngOnInit(): void {
  }

  onValidateTwo(obj: isbn, i: number): void {
    this.isbnService.getIsbn(obj.StrIsbn).
    subscribe(
      {
        next: this.createCallback(i), 
        error: e => console.log(e)
      }
    );
  }

  onAdd(): void {
    this.isbnList[this.isbnList.length] = { StrIsbn: "" };
  }

  //create a callback function that hides/shows the error/OK divs.
  createCallback(i: number) {

    return (r: any) => {
      console.log(r);

      var myErrorDiv = document.getElementById('myErrorDiv_' + i);
      var myOKDiv = document.getElementById('myOKDiv_' + i);

      if(myErrorDiv && myOKDiv) {
        if(r.status.hasError) {
          myErrorDiv.innerText = r.status.message;
          myErrorDiv.style.removeProperty('display');

          myOKDiv.style.display = 'none';

        } else { 
          myOKDiv.innerText = r.status.message;
          myOKDiv.style.removeProperty('display');

          myErrorDiv.style.display = 'none';
        }
      }
    }

  }

}
