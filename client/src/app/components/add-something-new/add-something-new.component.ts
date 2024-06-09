import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output, ViewChild, booleanAttribute } from '@angular/core';

@Component({
  selector: 'app-add-something-new',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './add-something-new.component.html',
  styleUrl: './add-something-new.component.scss'
})
export class AddSomethingNewComponent {
  @Input() public data = {
    name: "NAME",
    show: false,
    ERROR_MESSAGE: "",
    ok: "Save",
    cancel: "Cancel"
  }


  @Output() public save: EventEmitter<void> = new EventEmitter();
  @Output() public close: EventEmitter<void> = new EventEmitter();

  emitSave() {
    this.save.emit();
  }

  showModal() {
    this.data.show = true
  }
  hideModal() {
    this.data.ERROR_MESSAGE = ""
    this.data.show = false;
    this.close.emit();
  }


  ngOnChanges(changes: any) {
  }


}
