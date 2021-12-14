using System;
using MHP.CodingChallenge.Backend.Dependency.Inquiry;
using MHP.CodingChallenge.Backend.Dependency.Inquiry.Interfaces;
using Microsoft.Extensions.Logging;

namespace MHP.CodingChallenge.Backend.Dependency.Notifications
{
    public class EmailHandler: IEmailHandler
    {
        public virtual void SendEmail(Inquiry.Inquiry inquiry)
        {
            Console.WriteLine(string.Format("sending email for: {0}", inquiry.ToString()));
        }

       
    }
}
