import { Component, Input } from '@angular/core';
import { ConfirmationDialogComponent } from '../confirmation-dialog/confirmation-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { Participant } from '../model/participant.model';
import { RestService } from '../../services/rest.service';

@Component({
  selector: 'app-voting-page',
  templateUrl: './voting-page.component.html',
  styleUrl: './voting-page.component.css',
})
export class VotingPageComponent {
  @Input() participants!: Participant[];

  votingPage: boolean = true;
  thankYouPage: boolean = false;

  constructor(private dialog: MatDialog, private restService: RestService) {}

  openConfirmationDialog(participant: Participant): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '250px',
      data: { participantName: participant.name },
    });

    dialogRef.afterClosed().subscribe((result) => {
      if (result) {
        this.vote(participant);
      }
    });
  }

  vote(participant: Participant): void {
    this.restService.postData('/vote', participant).subscribe();
    this.switchPages();
  }

  switchPages(): void {
    this.votingPage = !this.votingPage;
    this.thankYouPage = !this.thankYouPage;
  }

  returnToVoting(): void {
    this.switchPages();
  }
}
